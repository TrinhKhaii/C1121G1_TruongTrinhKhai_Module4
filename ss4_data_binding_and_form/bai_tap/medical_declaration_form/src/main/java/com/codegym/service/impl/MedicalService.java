package com.codegym.service.impl;
/*
    Created by Trinh Khai
    Date: 01/04/2022
    Time: 15:01
*/

import com.codegym.model.MedicalDeclaration;
import com.codegym.repository.IMedicalRepository;
import com.codegym.service.IMedicalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MedicalService implements IMedicalService {
    @Autowired
    private IMedicalRepository iMedicalRepository;
    @Override
    public List<MedicalDeclaration> medicalDeclarationList() {
        return iMedicalRepository.medicalDeclarationList();
    }

    @Override
    public void save(MedicalDeclaration medicalDeclaration) {
        iMedicalRepository.save(medicalDeclaration);
    }

    @Override
    public MedicalDeclaration getMedicalDeclarationById(Integer id) {
        return iMedicalRepository.getMedicalDeclarationById(id);
    }

    @Override
    public void updateMedicalDeclaration(MedicalDeclaration medicalDeclaration) {
        iMedicalRepository.updateMedicalDeclaration(medicalDeclaration);
    }
}
