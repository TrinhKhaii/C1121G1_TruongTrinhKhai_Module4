package furama.model.service_entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

/*
    Created by Trinh Khai
    Date: 17/03/2022
    Time: 11:30
*/
@Entity
@Data
public class RentType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer rentTypeId;
    private String rentTypeName;
    private Double rentTypeCOst;

    @OneToMany(mappedBy = "rentType")
    private Set<Service> services;
}
