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
public class ContractDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer contractDetailId;

    @NotNull
    private String contractDetailCode;

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

    public ContractDetail() {
    }

    public Integer getContractDetailId() {
        return contractDetailId;
    }

    public void setContractDetailId(Integer contractDetailId) {
        this.contractDetailId = contractDetailId;
    }

    public String getContractDetailCode() {
        return contractDetailCode;
    }

    public void setContractDetailCode(String contractDetailCode) {
        this.contractDetailCode = contractDetailCode;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public AttachService getAttachService() {
        return attachService;
    }

    public void setAttachService(AttachService attachService) {
        this.attachService = attachService;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
