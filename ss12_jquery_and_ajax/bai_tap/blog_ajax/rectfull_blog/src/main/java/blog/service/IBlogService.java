package blog.service;
/*
    Created by Trinh Khai
    Date: 14/04/2022
    Time: 10:45
*/

import blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBlogService extends IGeneralService<Blog> {
    Iterable<Blog> findAllByCategoryId(Integer id);
    Page<Blog> findAllByBlogAuthorContaining(String author, Pageable pageable);
}
