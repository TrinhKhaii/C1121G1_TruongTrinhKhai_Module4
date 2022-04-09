package passbook.service.impl;
/*
    Created by Trinh Khai
    Date: 08/04/2022
    Time: 16:14
*/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import passbook.model.Customer;
import passbook.repository.ICustomerRepository;
import passbook.service.ICustomerService;

import java.util.List;
@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository iCustomerRepository;

    @Override
    public Customer findByNameAndCode(String code, String name) {
        return iCustomerRepository.findAllByCustomerCodeAndAndCustomerNameEquals(code, name);
    }
}
