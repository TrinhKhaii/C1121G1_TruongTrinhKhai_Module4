package phone.service.impl;
/*
    Created by Trinh Khai
    Date: 14/04/2022
    Time: 22:00
*/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import phone.model.Phone;
import phone.repository.IPhoneRepository;
import phone.service.IPhoneService;

import java.util.Optional;

@Service
public class PhoneService implements IPhoneService {

    @Autowired
    private IPhoneRepository iPhoneRepository;

    @Override
    public Iterable<Phone> findAll() {
        return iPhoneRepository.findAll();
    }

    @Override
    public Optional<Phone> findById(Long id) {
        return iPhoneRepository.findById(id);
    }

    @Override
    public Phone save(Phone phone) {
        return iPhoneRepository.save(phone);
    }

    @Override
    public void remove(Long id) {
        iPhoneRepository.deleteById(id);
    }
}
