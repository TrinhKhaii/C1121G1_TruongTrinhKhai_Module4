package customer.repository;

import customer.model.Customer;
import customer.model.Province;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Long> {
    Iterable<Customer> findAllByProvince(Province province);
    Page<Customer> findAllByFirstNameContaining(String firstname, Pageable pageable);
}
