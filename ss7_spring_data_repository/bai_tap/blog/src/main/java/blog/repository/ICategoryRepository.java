package blog.repository;
/*
    Created by Trinh Khai
    Date: 06/04/2022
    Time: 13:40
*/

import blog.model.Blog;
import blog.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<Category, Integer> {

}
