package blog.service;
/*
    Created by Trinh Khai
    Date: 04/04/2022
    Time: 22:41
*/

import blog.model.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();

    Blog findById(Integer id);

    void save(Blog customer);

    void remove(Integer id);
}
