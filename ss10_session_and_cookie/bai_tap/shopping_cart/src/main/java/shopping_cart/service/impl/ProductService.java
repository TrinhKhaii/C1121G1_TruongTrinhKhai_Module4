package shopping_cart.service.impl;
/*
    Created by Trinh Khai
    Date: 13/04/2022
    Time: 14:31
*/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shopping_cart.model.Product;
import shopping_cart.repository.IProductRepository;
import shopping_cart.service.IProductService;

import java.util.Optional;
@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository iProductRepository;

    @Override
    public Iterable<Product> findAll() {
        return iProductRepository.findAll();
    }

    @Override
    public Product findById(Integer id) {
        return iProductRepository.findById(id).orElse(null);
    }
}
