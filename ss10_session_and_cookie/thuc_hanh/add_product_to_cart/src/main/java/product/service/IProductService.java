package product.service;
/*
    Created by Trinh Khai
    Date: 13/04/2022
    Time: 11:41
*/

import product.model.Product;

import java.util.Optional;

public interface IProductService {
    Iterable<Product> findAll();
    Optional<Product> findById(Integer id);
}
