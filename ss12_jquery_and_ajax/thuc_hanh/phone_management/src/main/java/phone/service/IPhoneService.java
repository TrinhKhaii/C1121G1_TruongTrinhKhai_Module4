package phone.service;
/*
    Created by Trinh Khai
    Date: 14/04/2022
    Time: 21:58
*/

import phone.model.Phone;

import java.util.Optional;

public interface IPhoneService {
    Iterable<Phone> findAll();

    Optional<Phone> findById(Long id);

    Phone save(Phone phone);

    void remove(Long id);
}
