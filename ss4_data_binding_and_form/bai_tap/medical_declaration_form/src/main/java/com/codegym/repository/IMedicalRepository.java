package com.codegym.repository;
/*
    Created by Trinh Khai
    Date: 31/03/2022
    Time: 16:15
*/

import com.codegym.model.MedicalDeclaration;

import java.util.List;

public interface IMedicalRepository {
    List<MedicalDeclaration> medicalDeclarationList();

    void save(MedicalDeclaration medicalDeclaration);

    MedicalDeclaration getMedicalDeclarationById(Integer id);

    void updateMedicalDeclaration(MedicalDeclaration medicalDeclaration);
}
