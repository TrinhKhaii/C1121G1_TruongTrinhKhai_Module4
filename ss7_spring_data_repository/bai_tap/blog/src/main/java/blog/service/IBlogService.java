package blog.service;
/*
    Created by Trinh Khai
    Date: 04/04/2022
    Time: 22:41
*/

import blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();

    Blog findById(Integer id);

    void save(Blog customer);

    void remove(Integer id);

    Page<Blog> findAllBlog(Pageable pageable);

    Page<Blog> findBlogByName(String keyword, Pageable pageable);
}
