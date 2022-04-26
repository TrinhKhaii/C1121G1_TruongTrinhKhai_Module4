package medical_record.service.impl;
/*
    Created by Trinh Khai
    Date: 26/04/2022
    Time: 21:39
*/

import medical_record.model.Patient;
import medical_record.repository.IPatientRepository;
import medical_record.service.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class PatientService implements IPatientService {
    @Autowired
    private IPatientRepository iPatientRepository;

    @Override
    public Iterable<Patient> findAll() {
        return iPatientRepository.findAll();
    }

    @Override
    public Optional<Patient> findById(Integer id) {
        return iPatientRepository.findById(id);
    }

    @Override
    public void save(Patient patient) {
        iPatientRepository.save(patient);
    }

    @Override
    public void remove(Integer id) {
        iPatientRepository.deleteById(id);
    }
}
