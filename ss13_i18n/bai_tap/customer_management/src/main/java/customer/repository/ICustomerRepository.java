package customer.repository;
/*
    Created by Trinh Khai
    Date: 18/04/2022
    Time: 10:53
*/

import customer.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
}
