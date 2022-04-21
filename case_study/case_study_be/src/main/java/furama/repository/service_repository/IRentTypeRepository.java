package furama.repository.service_repository;
/*
    Created by Trinh Khai
    Date: 21/04/2022
    Time: 11:15
*/

import furama.model.service_entity.RentType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRentTypeRepository extends JpaRepository<RentType, Integer> {
}
