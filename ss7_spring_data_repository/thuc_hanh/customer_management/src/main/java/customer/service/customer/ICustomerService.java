package customer.service.customer;

import customer.model.Customer;
import customer.model.Province;
import customer.service.IGeneralService;

public interface ICustomerService extends IGeneralService<Customer> {
    Iterable<Customer> findAllByProvince(Province province);
}
