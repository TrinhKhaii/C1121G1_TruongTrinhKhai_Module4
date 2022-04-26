package furama.service;
/*
    Created by Trinh Khai
    Date: 24/04/2022
    Time: 00:17
*/


import furama.dto.ICustomerUseService;
import furama.model.customer_entity.CustomerUseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerUseServiceService {
    Page<CustomerUseService> findAllByCustomerNameContaining(String name, Pageable pageable);

    List<CustomerUseService> findAllCustomerUseService();

    Page<ICustomerUseService> findAllCustomerUseServicePage(Pageable pageable);
}
