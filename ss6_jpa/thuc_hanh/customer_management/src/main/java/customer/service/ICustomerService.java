package customer.service;
/*
    Created by Trinh Khai
    Date: 04/04/2022
    Time: 22:41
*/

import customer.model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();

    Customer findById(Integer id);

    void save(Customer customer);

    void remove(Integer id);

    boolean insertWithStoredProcedure(Customer customer);
}
