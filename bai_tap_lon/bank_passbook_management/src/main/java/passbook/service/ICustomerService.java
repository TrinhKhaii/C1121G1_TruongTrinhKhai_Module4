package passbook.service;
/*
    Created by Trinh Khai
    Date: 08/04/2022
    Time: 08:58
*/

import passbook.model.Customer;

import java.util.List;

public interface ICustomerService {
    Customer findByNameAndCode(String code, String name);

    Customer findByCode(String code);
}
