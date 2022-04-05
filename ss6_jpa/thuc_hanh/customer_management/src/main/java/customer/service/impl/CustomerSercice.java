package customer.service.impl;
/*
    Created by Trinh Khai
    Date: 04/04/2022
    Time: 22:42
*/

import customer.model.Customer;
import customer.repository.ICustomerRepository;
import customer.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerSercice implements ICustomerService {
    @Autowired
    private ICustomerRepository iCustomerRepository;
    @Override
    public List<Customer> findAll() {
        return iCustomerRepository.findAll();
    }

    @Override
    public Customer findById(Integer id) {
        return iCustomerRepository.findById(id);
    }

    @Override
    public void save(Customer customer) {
        iCustomerRepository.save(customer);
    }

    @Override
    public void remove(Integer id) {
        iCustomerRepository.remove(id);
    }

    @Override
    public boolean insertWithStoredProcedure(Customer customer) {
        return iCustomerRepository.insertWithStoredProcedure(customer);
    }
}
