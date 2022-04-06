package customer.service.customer;

import customer.model.Customer;
import customer.model.Province;
import customer.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICustomerService extends IGeneralService<Customer> {
    Iterable<Customer> findAllByProvince(Province province);
    Page<Customer> findAll(Pageable pageable);
    Page<Customer> findAllByFirstNameContaining(String firstname, Pageable pageable);
}
