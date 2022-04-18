package furama.model.contract_entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

/*
    Created by Trinh Khai
    Date: 17/03/2022
    Time: 13:44
*/
@Entity
@Data
public class AttachService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer attachServiceId;
    @NotNull
    private String attachServiceName;
    @NotNull
    private Double attachServiceCost;
    @NotNull
    private String attachServiceUnit;
    private String attachServiceStatus;

    @OneToMany(mappedBy = "attachService")
    private Set<ContractDetail> contractDetails;
}
