package furama.repository.customer_repository;
/*
    Created by Trinh Khai
    Date: 17/04/2022
    Time: 21:06
*/

import furama.model.customer_entity.CustomerType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerTypeRepository extends JpaRepository<CustomerType, Integer> {
}
