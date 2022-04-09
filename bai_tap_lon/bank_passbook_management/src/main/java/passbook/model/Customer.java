package passbook.model;
/*
    Created by Trinh Khai
    Date: 08/04/2022
    Time: 08:33
*/

import javax.persistence.*;
import java.util.Set;
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer customerId;
    private String customerCode;
    private String customerName;
    @OneToMany(mappedBy = "customer")
    private Set<Passbook> passbooks;

    public Customer() {
    }

    public Customer(Integer customerId, String customerCode, String customerName, Set<Passbook> passbooks) {
        this.customerId = customerId;
        this.customerCode = customerCode;
        this.customerName = customerName;
        this.passbooks = passbooks;
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

    public Set<Passbook> getPassbooks() {
        return passbooks;
    }

    public void setPassbooks(Set<Passbook> passbooks) {
        this.passbooks = passbooks;
    }
}
