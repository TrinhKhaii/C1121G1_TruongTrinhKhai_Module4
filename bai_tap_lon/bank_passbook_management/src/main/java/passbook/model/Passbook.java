package passbook.model;

import javax.persistence.*;

/*
    Created by Trinh Khai
    Date: 08/04/2022
    Time: 08:37
*/
@Entity
public class Passbook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer passbookId;
    private String startDate;
    private Integer period;
    private Double depositAmount;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id", referencedColumnName = "customerId")
    private Customer customer;


    public Passbook() {
    }

    public Passbook(Integer passbookId, String startDate, Integer period, Double depositAmount, Customer customer) {
        this.passbookId = passbookId;
        this.startDate = startDate;
        this.period = period;
        this.depositAmount = depositAmount;
        this.customer = customer;
    }

    public Integer getPassbookId() {
        return passbookId;
    }

    public void setPassbookId(Integer passbookId) {
        this.passbookId = passbookId;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public Integer getPeriod() {
        return period;
    }

    public void setPeriod(Integer period) {
        this.period = period;
    }

    public Double getDepositAmount() {
        return depositAmount;
    }

    public void setDepositAmount(Double depositAmount) {
        this.depositAmount = depositAmount;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
