package furama.dto.contract_dto;
/*
    Created by Trinh Khai
    Date: 23/04/2022
    Time: 21:27
*/

import furama.model.contract_entity.AttachService;
import furama.model.contract_entity.Contract;
import furama.model.contract_entity.ContractDetail;
import furama.service.IContractDetailService;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class ContractDetailDTO implements Validator {
    private Integer contractDetailId;

    @NotBlank(message = "Mã hợp đồng chi tiết không được để trống.")
    @Pattern(regexp = "(^$|HDCT-\\d{4})", message = "Mã hợp đồng chi tiết phải có định dạng HDCT-XXXX, trong đó X là số tự nhiên.")
    private String contractDetailCode;

    private Contract contract;

    private AttachService attachService;

    @NotNull(message = "Số lượng không được để trống.")
    @Min(value = 0, message = "Số lượng phải là số dương.")
    private Integer quantity;

    private IContractDetailService iContractDetailService;

    public ContractDetailDTO() {
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

    public IContractDetailService getiContractDetailService() {
        return iContractDetailService;
    }

    public void setiContractDetailService(IContractDetailService iContractDetailService) {
        this.iContractDetailService = iContractDetailService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        ContractDetailDTO contractDetailDTO = (ContractDetailDTO) target;
        String contractDetailCurrentCode = contractDetailDTO.getContractDetailCode();
        ContractDetail contractDetail = this.iContractDetailService.findByCode(contractDetailCurrentCode);
        if (contractDetail != null) {
            if (contractDetail.getContractDetailCode().equals(contractDetailCurrentCode)) {
                errors.rejectValue("contractDetailCode", "", "Mã hợp đồng chi tiết đã tồn tại.");
            }
        }

    }
}
