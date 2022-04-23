package furama.service.impl;
/*
    Created by Trinh Khai
    Date: 23/04/2022
    Time: 20:42
*/

import furama.model.contract_entity.ContractDetail;
import furama.repository.contract_repository.IContractDetailRepository;
import furama.service.IContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContractDetailService implements IContractDetailService {
    @Autowired
    private IContractDetailRepository iContractDetailRepository;

    @Override
    public Iterable<ContractDetail> findAll() {
        return iContractDetailRepository.findAll();
    }

    @Override
    public ContractDetail findByCode(String code) {
        return iContractDetailRepository.findByContractDetailCode(code);
    }

    @Override
    public void save(ContractDetail contractDetail) {
        iContractDetailRepository.save(contractDetail);
    }
}
