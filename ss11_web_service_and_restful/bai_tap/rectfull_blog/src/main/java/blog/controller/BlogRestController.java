package blog.controller;

import blog.model.Blog;
import blog.model.Category;
import blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

/*
    Created by Trinh Khai
    Date: 14/04/2022
    Time: 10:58
*/
@RestController
@RequestMapping(value = "/api/blog")
@CrossOrigin
public class BlogRestController {
    @Autowired
    private IBlogService iBlogService;

    @GetMapping(value = "list")
    public ResponseEntity<Page<Blog>> findAllBlog(@RequestParam("searchVal") Optional<String> search,
                                                  @PageableDefault(value = 3)Pageable pageable) {
//        List<Blog> blogs = (List<Blog>) iBlogService.findAll();
        String searchValue = search.orElse("");
        Page<Blog> blogs = iBlogService.findAllByBlogAuthorContaining(searchValue, pageable);
        if (blogs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }

    @PostMapping(value = "/save")
    public ResponseEntity<Void> saveBlog(@RequestBody Blog blog) {
        Date utilDate = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
        blog.setCreateDate(dateFormat.format(utilDate.getTime()));
        iBlogService.save(blog);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Blog> findBlogById(@PathVariable("id") Integer id) {
        Optional<Blog> blogOptional = iBlogService.findById(id);
        if (!blogOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(blogOptional.get(), HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Blog> updateBlog(@PathVariable("id") Integer id, @RequestBody Blog blog) {
        Optional<Blog> blogOptional = iBlogService.findById(id);
        if (!blogOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        blog.setBlogId(blogOptional.get().getBlogId());
        Category category = new Category();
        category.setCategoryId(blogOptional.get().getCategory().getCategoryId());
        blog.setCategory(category);
        return new ResponseEntity<>(iBlogService.save(blog), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Blog> delete(@PathVariable("id") Integer id) {
        Optional<Blog> blogOptional = iBlogService.findById(id);
        if (!blogOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        iBlogService.remove(id);

        return new ResponseEntity<>(blogOptional.get(), HttpStatus.OK);
    }

    @GetMapping(value = "/search/{categoryId}")
    public ResponseEntity<Iterable<Blog>> searchByCategoryId(@PathVariable("categoryId") Integer id) {
        Iterable<Blog> blogs =iBlogService.findAllByCategoryId(id);
        if (blogs == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }
}
