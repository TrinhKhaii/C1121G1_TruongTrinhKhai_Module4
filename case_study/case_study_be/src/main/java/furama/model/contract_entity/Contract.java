package furama.model.contract_entity;

import furama.model.customer_entity.Customer;
import furama.model.employee_entity.Employee;
import furama.model.service_entity.Service;
import lombok.Data;

import javax.persistence.*;

import javax.validation.constraints.NotNull;
import java.util.Set;

/*
    Created by Trinh Khai
    Date: 17/04/2022
    Time: 10:17
*/
@Entity
@Data
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @NotNull
    private Integer contractId;

    @NotNull
    @Column(columnDefinition = "datetime")
    private String contractStartDate;

    @NotNull
    @Column(columnDefinition = "datetime")
    private String contractEndDate;

    @NotNull
    private Double contractDeposit;

    @NotNull
    private Double contractTotalMoney;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "employeeId")
    private Employee employee;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "customerId")
    private Customer customer;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "service_id", referencedColumnName = "serviceId")
    private Service service;

    @OneToMany(mappedBy = "contract")
    private Set<ContractDetail> contractDetails;

}
