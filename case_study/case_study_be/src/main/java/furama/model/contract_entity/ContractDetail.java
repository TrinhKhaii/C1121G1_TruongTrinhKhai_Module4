package furama.model.contract_entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/*
    Created by Trinh Khai
    Date: 17/04/2022
    Time: 10:27
*/
@Entity
@Data
public class ContractDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer contract_detail_id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "contract_id", referencedColumnName = "contractId")
    private Contract contract;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "attach_service_id", referencedColumnName = "attachServiceId")
    private AttachService attachService;

    @NotNull
    private Integer quantity;
}
