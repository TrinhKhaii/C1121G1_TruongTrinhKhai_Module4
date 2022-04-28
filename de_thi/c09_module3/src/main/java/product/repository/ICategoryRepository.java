package product.repository;
/*
    Created by Trinh Khai
    Date: 27/04/2022
    Time: 21:32
*/

import org.springframework.data.jpa.repository.JpaRepository;
import product.model.Category;

public interface ICategoryRepository extends JpaRepository<Category, Integer> {
}
