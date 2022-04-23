package furama.service;
/*
    Created by Trinh Khai
    Date: 23/04/2022
    Time: 20:41
*/

import furama.model.contract_entity.ContractDetail;

public interface IContractDetailService {
    Iterable<ContractDetail> findAll();

    ContractDetail findByCode(String code);

    void save(ContractDetail contractDetail);
}
