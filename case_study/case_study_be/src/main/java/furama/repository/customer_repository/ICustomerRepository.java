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
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
    @Query(value = "select * from customer where customer.delete_flag = 0 and customer.name like concat('%',:customer_name,'%')", nativeQuery = true)
    Page<Customer> findAllByNameContaining(@Param("customer_name") String name, Pageable pageable);

    Customer findByCustomerCode(String name);
}
