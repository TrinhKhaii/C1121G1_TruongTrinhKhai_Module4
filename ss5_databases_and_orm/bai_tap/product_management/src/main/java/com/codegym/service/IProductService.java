package com.codegym.service;
/*
    Created by Trinh Khai
    Date: 01/04/2022
    Time: 10:23
*/

import com.codegym.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();

    void save(Product product);

    Product findById(Integer id);

    void update(Product product);

    void remove(Integer id);

    List<Product> productListSearchByName(String name);
}
