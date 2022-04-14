package blog.controller;

import blog.model.Blog;
import blog.model.Category;
import blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/*
    Created by Trinh Khai
    Date: 14/04/2022
    Time: 10:58
*/
@RestController
@RequestMapping(value = "/api/blog")
public class BlogRestController {
    @Autowired
    private IBlogService iBlogService;

    @GetMapping(value = "list")
    public ResponseEntity<Iterable<Blog>> findAllBlog() {
        List<Blog> blogs = (List<Blog>) iBlogService.findAll();
        if (blogs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }

    @PostMapping(value = "/save")
    public ResponseEntity<Void> saveBlog(@RequestBody Blog blog) {
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
