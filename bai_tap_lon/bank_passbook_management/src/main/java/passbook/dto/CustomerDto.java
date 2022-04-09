package passbook.dto;
/*
    Created by Trinh Khai
    Date: 08/04/2022
    Time: 09:06
*/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import passbook.model.Customer;
import passbook.repository.ICustomerRepository;
import passbook.service.ICustomerService;
import passbook.service.IPassbookService;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.List;

public class CustomerDto implements Validator {
    private Integer customerId;

    @NotEmpty(message = "Customer code can not empty.")
    @Pattern(regexp = "(^$|^KH-\\d{3}$)", message = "Customer code must be in KH-XXX format, where X is integer number.")
    private String customerCode;

    @NotEmpty(message = "Customer name can not empty.")
    @Pattern(regexp = "(^$|^[\\p{Lu}\\p{Ll}]+( [\\p{Lu}\\p{Ll}]+)*$)", message = "Customer name cannot have any extra spaces or no characters or number.")
    private String customerName;

    public CustomerDto() {
    }

    public CustomerDto(Integer customerId, String customerCode, String customerName) {
        this.customerId = customerId;
        this.customerCode = customerCode;
        this.customerName = customerName;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }
    @Autowired
    private ICustomerService iCustomerService;

    @Override
    public void validate(Object target, Errors errors) {
        CustomerDto customerDto = (CustomerDto) target;
        String customerCode = customerDto.getCustomerCode();

        Customer customer = iCustomerService.findByCode(customerCode);
        if (customer.getCustomerCode().equals(customerDto.getCustomerCode()) && !customer.getCustomerName().equals(customerDto.getCustomerName())) {
            errors.rejectValue("customerCode", "customerCode.exist", "Already exist this customer code.");
        }
    }
}
