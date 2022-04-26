package furama.dto;
/*
    Created by Trinh Khai
    Date: 26/04/2022
    Time: 08:53
*/

public interface ICustomerUseService {
    Integer getId();
    String getCustomerCode();
    String getCustomerName();
    String getContractCode();
    String getServiceName();
    Integer getServiceCost();
    String getAttachServiceName();
    Integer getAttachServiceCost();
    Integer getQuantity();
    Integer getTotal();
}
