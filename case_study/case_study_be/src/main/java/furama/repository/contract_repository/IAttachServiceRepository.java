package furama.repository.contract_repository;
/*
    Created by Trinh Khai
    Date: 23/04/2022
    Time: 20:50
*/

import furama.model.contract_entity.AttachService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAttachServiceRepository extends JpaRepository<AttachService, Integer> {
}
