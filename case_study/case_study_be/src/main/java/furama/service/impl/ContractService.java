package furama.service.impl;
/*
    Created by Trinh Khai
    Date: 17/04/2022
    Time: 15:17
*/

import furama.model.contract_entity.Contract;
import furama.repository.contract_repository.IContractRepository;
import furama.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class ContractService implements IContractService {
    @Autowired
    private IContractRepository iContractRepository;

    public ContractService(IContractRepository iContractRepository) {
        this.iContractRepository = iContractRepository;
    }

    @Override
    public Iterable<Contract> findAll() {
        return iContractRepository.findAll();
    }

    @Override
    public Optional<Contract> findById(Integer id) {
        return iContractRepository.findById(id);
    }

    @Override
    public void save(Contract contract) {
        iContractRepository.save(contract);
    }

    @Override
    public void remove(Integer id) {
        iContractRepository.deleteById(id);
    }

    @Override
    public Page<Contract> findAllByName(String name, Pageable pageable) {
        return iContractRepository.findAllByDeleteFlagAndCustomer_NameContaining(false, name, pageable);
    }

    @Override
    public Contract findByCode(String code) {
        return iContractRepository.findByContractCode(code);
    }
}
