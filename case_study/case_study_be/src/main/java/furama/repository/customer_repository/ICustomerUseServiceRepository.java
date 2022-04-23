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

public interface ICustomerUseServiceRepository extends JpaRepository<CustomerUseService, Integer> {

    @Query(value = "select customer.customer_code, customer.`name`, contract.contract_code, service.service_name, service.service_cost,\n" +
            "attach_service.attach_service_name, attach_service.attach_service_cost, contract_detail.quantity,\n" +
            "(ifnull(service.service_cost, 0) + ifnull(attach_service.attach_service_cost * contract_detail.quantity, 0)) as total from contract\n" +
            "inner join customer on customer.customer_id = contract.customer_id\n" +
            "inner join service on service.service_id = contract.service_id\n" +
            "inner join contract_detail on contract_detail.contract_id = contract.contract_id\n" +
            "inner join attach_service on contract_detail.attach_service_id = attach_service.attach_service_id\n" +
            "where customer.name like concat('%',:customer_name,'%')\";", nativeQuery = true)
    Page<CustomerUseService> findAllByCustomerUseService(@Param("customer_name") String name, Pageable pageable);
}
