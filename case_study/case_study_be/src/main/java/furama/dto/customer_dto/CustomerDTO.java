package furama.dto.customer_dto;
/*
    Created by Trinh Khai
    Date: 17/04/2022
    Time: 13:55
*/

import furama.dto.PersonDTO;
import furama.model.customer_entity.Customer;
import furama.model.customer_entity.CustomerType;
import furama.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class CustomerDTO extends PersonDTO implements Validator {
    private Integer customerId;

    @NotBlank(message = "Mã khách hàng không được để trống.")
    @Pattern(regexp = "(^$|KH-\\d{4})", message = "Mã khách hàng phải có định dạng KH-XXXX, trong đó X là số tự nhiên.")
    private String customerCode;

    @NotBlank(message = "Giới tính không được để trống")
    private String gender;

    private CustomerType customerType;

    private ICustomerService iCustomerService;

    public CustomerDTO() {
        setDeleteFlag(false);
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public ICustomerService getiCustomerService() {
        return iCustomerService;
    }

    public void setiCustomerService(ICustomerService iCustomerService) {
        this.iCustomerService = iCustomerService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }


    @Override
    public void validate(Object target, Errors errors) {
        CustomerDTO customerDTO = (CustomerDTO) target;
        String customerCurrentCode = customerDTO.getCustomerCode();
        Customer customer = this.iCustomerService.findByCode(customerCurrentCode);
        if (customer != null) {
            if (customer.getCustomerCode().equals(customerCurrentCode)) {
                errors.rejectValue("customerCode", "", "Mã khách hàng đã tồn tại.");
            }
        }
    }
}
