package blog.controller;

import blog.model.Blog;
import blog.model.Category;
import blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/*
    Created by Trinh Khai
    Date: 14/04/2022
    Time: 13:42
*/
@RestController
@RequestMapping(value = "/api/category")
public class CategoryRestController {

    @Autowired
    private ICategoryService iCategoryService;

    @GetMapping(value = "/list")
    public ResponseEntity<Iterable<Category>> findAllBlog() {
        List<Category> categories = (List<Category>) iCategoryService.findAll();
        if (categories.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }
}
