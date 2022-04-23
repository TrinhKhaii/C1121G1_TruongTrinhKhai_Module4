package furama.service.impl;
/*
    Created by Trinh Khai
    Date: 23/04/2022
    Time: 21:12
*/

import furama.model.contract_entity.AttachService;
import furama.repository.contract_repository.IAttachServiceRepository;
import furama.service.IAttachServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class AttachServiceService implements IAttachServiceService {
    @Autowired
    private IAttachServiceRepository iAttachServiceRepository;

    @Override
    public Iterable<AttachService> findAll() {
        return iAttachServiceRepository.findAll();
    }

    @Override
    public Optional<AttachService> findById(Integer id) {
        return iAttachServiceRepository.findById(id);
    }

    @Override
    public void save(AttachService attachService) {
        iAttachServiceRepository.save(attachService);
    }

    @Override
    public void remove(Integer id) {
        iAttachServiceRepository.deleteById(id);
    }
}
