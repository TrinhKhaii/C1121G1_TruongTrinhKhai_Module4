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

public interface IServiceRepository extends JpaRepository<Service, Integer> {
    Page<Service> findAllByServiceNameContaining(String serviceName, Pageable pageable);
}
