package com.codegym.repository.impl;
/*
    Created by Trinh Khai
    Date: 01/04/2022
    Time: 10:38
*/

import com.codegym.model.Product;
import com.codegym.repository.IProductRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.*;

@Transactional
@Repository
public class ProductRepository implements IProductRepository {
    @PersistenceContext
    private EntityManager entityManager;

    private static final String FIND_ALL = "select p from product p";
    private static final String SEARCH_BY_NAME = "select p from product p where p.name like :searchName";

    @Override
    public List<Product> findAll() {
        TypedQuery<Product> typedQuery = entityManager.createQuery(FIND_ALL, Product.class);
        return typedQuery.getResultList();
    }

    @Override
    public void save(Product product) {
        entityManager.persist(product);
    }

    @Override
    public Product findById(Integer id) {
        return entityManager.find(Product.class, id);
    }

    @Override
    public void update(Product product) {
        entityManager.merge(product);
    }

    @Override
    public void remove(Integer id) {

        entityManager.remove(findById(id));
    }

    @Override
    public List<Product> productListSearchByName(String name) {
        TypedQuery<Product> typedQuery = entityManager.createQuery(SEARCH_BY_NAME, Product.class);
        typedQuery.setParameter("searchName", "%" + name + "%");
        return typedQuery.getResultList();
    }
}
