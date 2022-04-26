package furama.dto.contract_dto;
/*
    Created by Trinh Khai
    Date: 22/04/2022
    Time: 18:11
*/

import furama.model.contract_entity.Contract;
import furama.model.customer_entity.Customer;
import furama.model.employee_entity.Employee;
import furama.model.service_entity.Service;
import furama.service.IContractService;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class ContractDTO implements Validator {
    private Integer contractId;

    @NotBlank(message = "Mã hợp đồng không được để trống.")
    @Pattern(regexp = "(^$|HD-\\d{4})", message = "Mã hợp đồng phải có định dạng HD-XXXX, trong đó X là số tự nhiên.")
    private String contractCode;

    @NotBlank(message = "Ngày bắt đầu không được để trống.")
    private String contractStartDate;

    @NotBlank(message = "Ngày kết thúc không được để trống.")
    private String contractEndDate;

    @NotNull(message = "Tiền đặt cọc không được để trống.")
    private Double contractDeposit;


    private Double contractTotalMoney;

    private Boolean deleteFlag;

    private Employee employee;

    private Customer customer;

    private Service service;

    private IContractService iContractService;

    public ContractDTO() {
        setDeleteFlag(false);
        setContractTotalMoney(0.0);
    }

    public Integer getContractId() {
        return contractId;
    }

    public void setContractId(Integer contractId) {
        this.contractId = contractId;
    }

    public String getContractCode() {
        return contractCode;
    }

    public void setContractCode(String contractCode) {
        this.contractCode = contractCode;
    }

    public String getContractStartDate() {
        return contractStartDate;
    }

    public void setContractStartDate(String contractStartDate) {
        this.contractStartDate = contractStartDate;
    }

    public String getContractEndDate() {
        return contractEndDate;
    }

    public void setContractEndDate(String contractEndDate) {
        this.contractEndDate = contractEndDate;
    }

    public Double getContractDeposit() {
        return contractDeposit;
    }

    public void setContractDeposit(Double contractDeposit) {
        this.contractDeposit = contractDeposit;
    }

    public Double getContractTotalMoney() {
        return contractTotalMoney;
    }

    public void setContractTotalMoney(Double contractTotalMoney) {
        this.contractTotalMoney = contractTotalMoney;
    }

    public Boolean getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Boolean deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public IContractService getiContractService() {
        return iContractService;
    }

    public void setiContractService(IContractService iContractService) {
        this.iContractService = iContractService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        ContractDTO contractDTO = (ContractDTO) target;
        String contractCurrentCode = contractDTO.getContractCode();
        Contract contract = this.iContractService.findByCode(contractCurrentCode);
        if (contract != null) {
            if (contract.getContractCode().equals(contractCurrentCode)) {
                errors.rejectValue("contractCode", "", "Mã hợp đồng đã tồn tại.");
            }
        }
    }
}
