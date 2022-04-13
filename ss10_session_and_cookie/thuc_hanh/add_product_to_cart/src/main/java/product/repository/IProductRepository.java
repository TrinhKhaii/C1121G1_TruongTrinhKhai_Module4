package product.repository;
/*
    Created by Trinh Khai
    Date: 13/04/2022
    Time: 11:40
*/

import org.springframework.data.repository.PagingAndSortingRepository;
import product.model.Product;

public interface IProductRepository extends PagingAndSortingRepository<Product, Integer> {
}
