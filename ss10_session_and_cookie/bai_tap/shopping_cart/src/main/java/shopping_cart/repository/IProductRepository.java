package shopping_cart.repository;
/*
    Created by Trinh Khai
    Date: 13/04/2022
    Time: 14:30
*/

import org.springframework.data.jpa.repository.JpaRepository;
import shopping_cart.model.Product;

public interface IProductRepository extends JpaRepository<Product, Integer> {
}
