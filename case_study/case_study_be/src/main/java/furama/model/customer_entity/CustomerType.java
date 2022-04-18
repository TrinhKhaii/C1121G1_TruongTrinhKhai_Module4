package furama.model.customer_entity;

import javax.persistence.*;
import java.util.Set;

/*
    Created by Trinh Khai
    Date: 16/04/2022
    Time: 22:19
*/
@Entity
public class CustomerType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer customerTypeId;
    private String customerTypeName;
    @OneToMany(mappedBy = "customerType")
    private Set<Customer> customers;

    public CustomerType() {
    }

    public Integer getCustomerTypeId() {
        return customerTypeId;
    }

    public void setCustomerTypeId(Integer customerTypeId) {
        this.customerTypeId = customerTypeId;
    }

    public String getCustomerTypeName() {
        return customerTypeName;
    }

    public void setCustomerTypeName(String customerTypeName) {
        this.customerTypeName = customerTypeName;
    }
}
