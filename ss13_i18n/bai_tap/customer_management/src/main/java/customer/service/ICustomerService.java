package customer.service;
/*
    Created by Trinh Khai
    Date: 18/04/2022
    Time: 10:54
*/

import customer.model.Customer;

public interface ICustomerService {
    Iterable<Customer> findAll();
}