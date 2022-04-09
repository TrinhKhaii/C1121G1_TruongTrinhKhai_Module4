package passbook.repository;
/*
    Created by Trinh Khai
    Date: 08/04/2022
    Time: 08:57
*/

import org.springframework.data.jpa.repository.JpaRepository;
import passbook.model.Customer;

import java.util.List;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
    Customer findAllByCustomerCodeAndAndCustomerNameEquals(String code, String name);
}
