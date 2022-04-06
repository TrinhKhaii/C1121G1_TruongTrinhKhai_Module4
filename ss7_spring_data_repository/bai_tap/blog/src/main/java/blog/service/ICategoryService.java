package blog.service;
/*
    Created by Trinh Khai
    Date: 06/04/2022
    Time: 13:41
*/

import blog.model.Category;

import java.util.List;

public interface ICategoryService{
    List<Category> findAll();

    Category findById(Integer id);

    void save(Category category);

    void remove(Integer id);
}
