package furama.dto.customer_dto;
/*
    Created by Trinh Khai
    Date: 17/04/2022
    Time: 13:55
*/

import furama.dto.PersonDTO;
import furama.model.customer_entity.CustomerType;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class CustomerDTO extends PersonDTO {
    private Integer customerId;

    @NotBlank(message = "Mã khách hàng không được để trống")
    @Pattern(regexp = "(^$|KH-\\d{4})", message = "Mã khách hàng phải có định dạng KH-XXXX, trong đó X là số tự nhiên.")
    private String customerCode;

    @NotBlank(message = "Giới tính không được để trống")
    private String gender;

    private CustomerType customerType;

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
}
