package furama.repository.customer_repository;
/*
    Created by Trinh Khai
    Date: 24/04/2022
    Time: 00:06
*/

import furama.model.customer_entity.CustomerUseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerUseServiceRepository extends JpaRepository<CustomerUseService, Integer> {
    Page<CustomerUseService> findAllByCustomerNameContaining(String name, Pageable pageable);
}
