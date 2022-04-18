package furama.repository.customer_repository;
/*
    Created by Trinh Khai
    Date: 17/04/2022
    Time: 10:47
*/

import furama.model.customer_entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
    Page<Customer> findAllByNameContaining(String name, Pageable pageable);
}
