package furama.dto.customer_dto;
/*
    Created by Trinh Khai
    Date: 17/04/2022
    Time: 13:55
*/

import furama.dto.PersonDTO;
import furama.model.customer_entity.CustomerType;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class CustomerDTO extends PersonDTO {
    private Integer customerId;

    @NotBlank(message = "Customer code can not empty")
    @Pattern(regexp = "(^$|KH-\\d{4})", message = "Customer code must be in KH-XXXX format, where X is integer number.")
    private String customerCode;

    @NotBlank(message = "Gender can not be empty")
    private String gender;

//    @NotEmpty(message = "Customer type can not be empty")
    private CustomerType customerType;

    public CustomerDTO() {
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
}
