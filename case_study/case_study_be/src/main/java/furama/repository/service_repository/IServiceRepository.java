package furama.repository.service_repository;
/*
    Created by Trinh Khai
    Date: 17/04/2022
    Time: 10:48
*/

import furama.model.service_entity.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IServiceRepository extends JpaRepository<Service, Integer> {
    @Query(value = "select * from service where service.delete_flag = 0 and service.service_name like concat('%',:service_name,'%')", nativeQuery = true)
    Page<Service> findAllByServiceNameContaining(@Param("service_name") String serviceName, Pageable pageable);

    @Query(value = "select * from service where service.service_type_id = 1 or service.service_type_id = 2", nativeQuery = true)
    Iterable<Service> findAllByServiceTypeId();
}
