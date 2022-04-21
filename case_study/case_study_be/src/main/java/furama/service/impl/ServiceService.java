package furama.service.impl;
/*
    Created by Trinh Khai
    Date: 21/04/2022
    Time: 10:23
*/

import furama.model.service_entity.RentType;
import furama.model.service_entity.Service;
import furama.model.service_entity.ServiceType;
import furama.repository.service_repository.IRentTypeRepository;
import furama.repository.service_repository.IServiceRepository;
import furama.repository.service_repository.IServiceTypeRepository;
import furama.service.IServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
@org.springframework.stereotype.Service
public class ServiceService implements IServiceService {
    @Autowired
    private IServiceRepository iServiceRepository;

    @Autowired
    private IServiceTypeRepository iServiceTypeRepository;

    @Autowired
    private IRentTypeRepository iRentTypeRepository;

    @Override
    public Iterable<Service> findAll() {
        return iServiceRepository.findAll();
    }

    @Override
    public Optional<Service> findById(Integer id) {
        return iServiceRepository.findById(id);
    }

    @Override
    public void save(Service service) {
        iServiceRepository.save(service);
    }

    @Override
    public void remove(Integer id) {
        iServiceRepository.deleteById(id);
    }

    @Override
    public Page<Service> findAllByName(String name, Pageable pageable) {
        return iServiceRepository.findAllByServiceNameContaining(name, pageable);
    }

    @Override
    public Iterable<ServiceType> findAllServiceType() {
        return iServiceTypeRepository.findAll();
    }

    @Override
    public Iterable<RentType> findAllRentType() {
        return iRentTypeRepository.findAll();
    }
}
