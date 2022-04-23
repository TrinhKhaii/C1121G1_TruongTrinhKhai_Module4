package furama.service;
/*
    Created by Trinh Khai
    Date: 17/04/2022
    Time: 15:13
*/

import furama.model.contract_entity.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IContractService extends IGeneralService<Contract>{
    Page<Contract> findAllByName(String name, Pageable pageable);

    Contract findByCode(String code);
}
