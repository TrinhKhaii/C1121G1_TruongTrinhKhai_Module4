package com.codegym.service;
/*
    Created by Trinh Khai
    Date: 01/04/2022
    Time: 14:59
*/

import com.codegym.model.MedicalDeclaration;

import java.util.List;

public interface IMedicalService {
    List<MedicalDeclaration> medicalDeclarationList();

    void save(MedicalDeclaration medicalDeclaration);

    MedicalDeclaration getMedicalDeclarationById(Integer id);

    void updateMedicalDeclaration(MedicalDeclaration medicalDeclaration);
}
