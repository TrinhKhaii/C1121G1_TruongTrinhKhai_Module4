package furama.model.customer_entity;
/*
    Created by Trinh Khai
    Date: 16/04/2022
    Time: 22:19
*/

import furama.model.Person;
import furama.model.contract_entity.Contract;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
public class Customer extends Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer customerId;

    @NotNull
    private String customerCode;

    @NotNull
    private String gender;

    @ManyToOne
    @JoinColumn(name = "customer_type_id", referencedColumnName = "customerTypeId")
    private CustomerType customerType;

    @OneToMany(mappedBy = "customer")
    private Set<Contract> contracts;

    public Customer() {
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

//    <th>STT</th>
//    <th>Mã khách hàng</th>
//        <th>Tên</th>
//    <th>Giới tính</th>
//    <th>Ngày sinh</th>
//        <th>CMND</th>
//    <th>Số điện thoại</th>
//        <th>Email</th>
//    <th>Địa chỉ</th>
//        <th>Loại</th>
//    <th>Chỉnh Sửa</th>
//        <th>Xoá</th>

}
