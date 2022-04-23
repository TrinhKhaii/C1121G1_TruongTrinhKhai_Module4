package furama.repository.contract_repository;
/*
    Created by Trinh Khai
    Date: 23/04/2022
    Time: 20:36
*/

import furama.model.contract_entity.ContractDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IContractDetailRepository extends JpaRepository<ContractDetail, Integer> {
    ContractDetail findByContractDetailCode(String code);
}
