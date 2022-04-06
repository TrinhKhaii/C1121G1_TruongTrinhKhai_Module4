package blog.repository;
/*
    Created by Trinh Khai
    Date: 05/04/2022
    Time: 11:43
*/

import blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    Page<Blog> findAllByOrderByCreateDate(Pageable pageable);

    Page<Blog> findAllByBlogAuthorContainingOrderByCreateDate(String keyword, Pageable pageable);
}
