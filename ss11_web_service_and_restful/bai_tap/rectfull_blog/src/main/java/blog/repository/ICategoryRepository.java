package blog.repository;
/*
    Created by Trinh Khai
    Date: 14/04/2022
    Time: 10:41
*/

import blog.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;



public interface ICategoryRepository extends JpaRepository<Category, Integer> {
}
