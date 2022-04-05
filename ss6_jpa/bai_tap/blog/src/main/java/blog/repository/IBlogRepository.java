package blog.repository;
/*
    Created by Trinh Khai
    Date: 05/04/2022
    Time: 11:43
*/

import blog.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBlogRepository extends JpaRepository<Blog, Integer> {
}
