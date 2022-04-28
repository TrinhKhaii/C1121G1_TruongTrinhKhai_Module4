package product.service.impl;
/*
    Created by Trinh Khai
    Date: 27/04/2022
    Time: 21:31
*/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import product.model.Product;
import product.repository.IProductRepository;
import product.service.IProductService;

import java.util.List;
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
    public Optional<Product> findById(Integer id) {
        return iProductRepository.findById(id);
    }

    @Override
    public void save(Product product) {
        iProductRepository.save(product);
    }

    @Override
    public void remove(Integer id) {
        iProductRepository.deleteById(id);
    }

    @Override
    public Page<Product> findBySearchValue(String productName, String productPrice, String categgoryName, String color, Pageable pageable) {
        return iProductRepository.findAllBySearchValue(productName, productPrice, categgoryName, color, pageable);
    }

    @Override
    public void setDeleteFlagMutiple(List<String> idMutiple) {
        iProductRepository.setDeleteFlagMutiple(idMutiple);
    }
}
