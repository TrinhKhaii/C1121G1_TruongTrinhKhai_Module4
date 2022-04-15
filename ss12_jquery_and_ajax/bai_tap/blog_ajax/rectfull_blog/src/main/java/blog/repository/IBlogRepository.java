package blog.repository;
/*
    Created by Trinh Khai
    Date: 14/04/2022
    Time: 10:41
*/

import blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    Iterable<Blog> findAllByCategory_CategoryId(Integer categoryId);
    Page<Blog> findAllByBlogAuthorContaining(String author, Pageable pageable);
}
