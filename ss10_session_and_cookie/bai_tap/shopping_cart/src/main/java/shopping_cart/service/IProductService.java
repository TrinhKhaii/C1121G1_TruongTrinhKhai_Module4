package shopping_cart.service;
/*
    Created by Trinh Khai
    Date: 13/04/2022
    Time: 14:30
*/

import shopping_cart.model.Product;

import java.util.Optional;

public interface IProductService {
    Iterable<Product> findAll();
    Product findById(Integer id);
}
