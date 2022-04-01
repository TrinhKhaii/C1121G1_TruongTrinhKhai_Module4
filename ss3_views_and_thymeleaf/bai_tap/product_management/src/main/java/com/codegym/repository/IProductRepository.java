package com.codegym.repository;
/*
    Created by Trinh Khai
    Date: 01/04/2022
    Time: 10:37
*/

import com.codegym.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> findAll();

    void save(Product product);

    Product findById(Integer id);

    void update(Integer id, Product product);

    void remove(Integer id);

    List<Product> productListSearchByName(String name);
}
