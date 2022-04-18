package furama.repository.contract_repository;
/*
    Created by Trinh Khai
    Date: 17/04/2022
    Time: 10:49
*/

import furama.model.contract_entity.Contract;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IContractRepository extends JpaRepository<Contract, Integer> {
}
