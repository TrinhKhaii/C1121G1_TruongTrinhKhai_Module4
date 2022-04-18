package furama.model.service_entity;

import furama.model.contract_entity.Contract;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

/*
    Created by Trinh Khai
    Date: 17/04/2022
    Time: 09:33
*/
@Entity
@Data
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer serviceId;

    @NotNull
    private String serviceCode;

    @NotNull
    private String serviceName;

    private Integer service_area;
    @NotNull
    private Double serviceCost;
    private Integer serviceMaxPeople;
    private String standardRoom;
    private String descritionOtherConvenience;
    private Double poolArea;
    private Integer numberOdFloors;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "rent_type_id", referencedColumnName = "rentTypeId")
    private RentType rentType;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "service_type_id", referencedColumnName = "serviceTypeId")
    private ServiceType serviceType;

    @OneToMany(mappedBy = "service")
    private Set<Contract> contracts;
}
