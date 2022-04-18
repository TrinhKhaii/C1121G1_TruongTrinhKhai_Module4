package furama.model.service_entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

/*
    Created by Trinh Khai
    Date: 17/03/2022
    Time: 11:29
*/
@Entity
@Data
public class ServiceType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer serviceTypeId;
    private String serviceTypeName;

    @OneToMany(mappedBy = "serviceType")
    private Set<Service> services;
}
