package customer.repository;
/*
    Created by Trinh Khai
    Date: 04/04/2022
    Time: 22:37
*/

import customer.model.Customer;

import java.util.List;

public interface ICustomerRepository {
    List<Customer> findAll();

    Customer findById(Integer id);

    void save(Customer customer);

    void remove(Integer id);

    boolean insertWithStoredProcedure(Customer customer);
}
