package furama.repository.customer_repository;
/*
    Created by Trinh Khai
    Date: 24/04/2022
    Time: 00:06
*/

import furama.model.customer_entity.CustomerUseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface ICustomerUseServiceRepository extends JpaRepository<CustomerUseService, String> {
    Page<CustomerUseService> findAllByCustomerNameContaining(@Param("name") String name, Pageable pageable);

    @Query(value = "select contract.contract_id as id, " +
"customer.customer_code as customerCode, customer.name as customerName, contract.contract_code as contractCode, service.service_name as serviceName, service.service_cost as serviceCost, " +
            "attach_service.attach_service_name as attachServiceName, attach_service.attach_service_cost as attachServiceCost, contract_detail.quantity," +
            "(ifnull(service.service_cost, 0) + ifnull(attach_service.attach_service_cost * contract_detail.quantity, 0)) as total from contract " +
            "inner join customer on customer.customer_id = contract.customer_id " +
            "inner join service on service.service_id = contract.service_id " +
            "left join contract_detail on contract_detail.contract_id = contract.contract_id " +
            "left join attach_service on contract_detail.attach_service_id = attach_service.attach_service_id ",
            countQuery = "select count(*) from contract " +
                    "inner join customer on customer.customer_id = contract.customer_id " +
                    "inner join service on service.service_id = contract.service_id " +
                    "left join contract_detail on contract_detail.contract_id = contract.contract_id " +
                    "left join attach_service on contract_detail.attach_service_id = attach_service.attach_service_id ",
            nativeQuery = true)
    <T> Page<T> findAllCustomerUseServicePage(Class<T> classType, Pageable pageable);
}
