package furama.service;
/*
    Created by Trinh Khai
    Date: 24/04/2022
    Time: 00:17
*/


import furama.model.customer_entity.CustomerUseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICustomerUseServiceService {
    Page<CustomerUseService> findAllCustomerUseService(String name, Pageable pageable);
}
