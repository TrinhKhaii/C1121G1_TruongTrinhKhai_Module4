package furama.service.impl;
/*
    Created by Trinh Khai
    Date: 24/04/2022
    Time: 00:18
*/

import furama.model.customer_entity.CustomerUseService;
import furama.repository.customer_repository.ICustomerUseServiceRepository;
import furama.service.ICustomerUseServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class CustomerUseServiceService implements ICustomerUseServiceService {
    @Autowired
    private ICustomerUseServiceRepository iCustomerUseServiceRepository;


    @Override
    public Page<CustomerUseService> findAllCustomerUseService(String name, Pageable pageable) {
        return iCustomerUseServiceRepository.findAllByCustomerUseService(name, pageable);
    }
}
