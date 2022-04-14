package customer.repository;
/*
    Created by Trinh Khai
    Date: 14/04/2022
    Time: 05:14
*/

import customer.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerRepository extends JpaRepository<Customer,Long> {
}
