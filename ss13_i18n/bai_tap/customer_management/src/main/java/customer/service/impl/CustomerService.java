package customer.service.impl;
/*
    Created by Trinh Khai
    Date: 18/04/2022
    Time: 10:54
*/

import customer.model.Customer;
import customer.repository.ICustomerRepository;
import customer.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository iCustomerRepository;

    @Override
    public Iterable<Customer> findAll() {
        return iCustomerRepository.findAll();
    }
}
