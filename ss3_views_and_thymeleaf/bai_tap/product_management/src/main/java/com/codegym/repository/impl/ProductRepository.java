package com.codegym.repository.impl;
/*
    Created by Trinh Khai
    Date: 01/04/2022
    Time: 10:38
*/

import com.codegym.model.Product;
import com.codegym.repository.IProductRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Repository
public class ProductRepository implements IProductRepository {
    private static final Map<Integer, Product> productList;
    static {
        productList = new HashMap<>();
        productList.put(1, new Product(1, "Iphone 11", 3000000.0));
    }
    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productList.values());
    }

    @Override
    public void save(Product product) {
        productList.put(product.getId(), product);
    }

    @Override
    public Product findById(Integer id) {
        return productList.get(id);
    }

    @Override
    public void update(Integer id, Product product) {
        productList.put(id, product);
    }

    @Override
    public void remove(Integer id) {
        productList.remove(id);
    }

    @Override
    public List<Product> productListSearchByName(String name) {
        List<Product> productList1 = new ArrayList<>(productList.values());
        List<Product> result = new ArrayList<>();
        for (Product e: productList1) {
            if (e.getName().contains(name)) {
                result.add(e);
            }
        }
        return result;
    }
}
