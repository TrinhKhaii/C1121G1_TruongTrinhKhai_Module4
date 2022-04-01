package com.codegym.service;
/*
    Created by Trinh Khai
    Date: 01/04/2022
    Time: 06:11
*/

import com.codegym.model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();

    void save(Customer customer);

    Customer findById(int id);

    void update(int id, Customer customer);

    void remove(int id);
}
