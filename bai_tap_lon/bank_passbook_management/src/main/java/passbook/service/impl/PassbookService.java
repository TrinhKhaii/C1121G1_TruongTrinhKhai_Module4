package passbook.service.impl;
/*
    Created by Trinh Khai
    Date: 08/04/2022
    Time: 09:01
*/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import passbook.model.Passbook;
import passbook.repository.IPassbookRepository;
import passbook.service.IPassbookService;

import java.util.List;
@Service
public class PassbookService implements IPassbookService {
    @Autowired
    private IPassbookRepository iPassbookRepository;

    @Override
    public List<Passbook> findAll() {
        return iPassbookRepository.findAll();
    }

    @Override
    public Passbook findById(Integer id) {
        return iPassbookRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Passbook passbook) {
        iPassbookRepository.save(passbook);
    }

    @Override
    public void remove(Integer id) {
        iPassbookRepository.deleteById(id);
    }
}
