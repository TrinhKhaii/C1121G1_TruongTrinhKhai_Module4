package furama.service;
/*
    Created by Trinh Khai
    Date: 17/04/2022
    Time: 13:57
*/

import furama.model.customer_entity.Customer;
import furama.model.customer_entity.CustomerType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface ICustomerService extends IGeneralService<Customer>{
    Page<Customer> findAllByName(String name, Pageable pageable);

    Iterable<CustomerType> findAllCustomerType();
}
