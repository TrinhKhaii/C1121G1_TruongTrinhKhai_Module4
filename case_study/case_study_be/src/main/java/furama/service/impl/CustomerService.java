package furama.service.impl;
/*
    Created by Trinh Khai
    Date: 17/04/2022
    Time: 15:13
*/

import furama.model.customer_entity.Customer;
import furama.model.customer_entity.CustomerType;
import furama.repository.customer_repository.ICustomerRepository;
import furama.repository.customer_repository.ICustomerTypeRepository;
import furama.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository iCustomerRepository;

    @Autowired
    private ICustomerTypeRepository iCustomerTypeRepository;

    @Override
    public Iterable<Customer> findAll() {
        return iCustomerRepository.findAll();
    }

    @Override
    public Optional<Customer> findById(Integer id) {
        return iCustomerRepository.findById(id);
    }

    @Override
    public void save(Customer customer) {
        iCustomerRepository.save(customer);
    }

    @Override
    public void remove(Integer id) {
        iCustomerRepository.deleteById(id);
    }

    @Override
    public Page<Customer> findAllByName(String name, Pageable pageable) {
        return iCustomerRepository.findAllByNameContaining(name, pageable);
    }

    @Override
    public Iterable<CustomerType> findAllCustomerType() {
        return iCustomerTypeRepository.findAll();
    }
}
