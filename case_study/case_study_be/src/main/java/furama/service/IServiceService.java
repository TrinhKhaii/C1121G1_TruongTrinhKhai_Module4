package furama.service;
/*
    Created by Trinh Khai
    Date: 21/04/2022
    Time: 10:22
*/

import furama.model.service_entity.RentType;
import furama.model.service_entity.Service;
import furama.model.service_entity.ServiceType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IServiceService extends IGeneralService<Service>{
    Page<Service> findAllByName(String name, Pageable pageable);

    Iterable<ServiceType> findAllServiceType();

    Iterable<RentType> findAllRentType();

    Iterable<Service> findAllByServiceTypeId();
}
