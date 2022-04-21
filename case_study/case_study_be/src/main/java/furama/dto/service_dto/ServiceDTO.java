package furama.dto.service_dto;
/*
    Created by Trinh Khai
    Date: 21/04/2022
    Time: 08:50
*/

import furama.model.service_entity.RentType;
import furama.model.service_entity.ServiceType;

import javax.validation.constraints.*;


public abstract class ServiceDTO {
    private Integer serviceId;

    @NotBlank(message = "Mã dịch vụ không được để trống.")
    @Pattern(regexp = "(^$|DV-\\d{4})", message = "Mã dịch vụ phải có định dạng DV-XXXX, trong đó X là số tự nhiên.")
    private String serviceCode;

    @NotBlank(message = "Tên dịch vụ không được để trống.")
    private String serviceName;

    @Min(value = 0, message = "Diện tích sử dụng phải là số dương.")
    private Integer serviceArea;

    @NotNull(message = "Chi phí không được để trống.")
    @Min(value = 0, message = "Chi phí phải là số dương.")
    private Double serviceCost;

    @Min(value = 0, message = "Số lượng người tối đa phải là số dương.")
    private Integer serviceMaxPeople;

    private RentType rentType;

    private ServiceType serviceType;

    private Boolean deleteFlag;

    public ServiceDTO() {
        setDeleteFlag(false);
    }

    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public Integer getServiceArea() {
        return serviceArea;
    }

    public void setServiceArea(Integer serviceArea) {
        this.serviceArea = serviceArea;
    }

    public Double getServiceCost() {
        return serviceCost;
    }

    public void setServiceCost(Double serviceCost) {
        this.serviceCost = serviceCost;
    }

    public Integer getServiceMaxPeople() {
        return serviceMaxPeople;
    }

    public void setServiceMaxPeople(Integer serviceMaxPeople) {
        this.serviceMaxPeople = serviceMaxPeople;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public Boolean getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Boolean deleteFlag) {
        this.deleteFlag = deleteFlag;
    }
}

