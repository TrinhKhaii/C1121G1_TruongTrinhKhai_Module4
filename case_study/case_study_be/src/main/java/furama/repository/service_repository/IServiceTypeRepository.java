package furama.repository.service_repository;
/*
    Created by Trinh Khai
    Date: 21/04/2022
    Time: 11:08
*/

import furama.model.service_entity.ServiceType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IServiceTypeRepository extends JpaRepository<ServiceType, Integer> {
}
