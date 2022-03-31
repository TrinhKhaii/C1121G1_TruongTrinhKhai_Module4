package com.codegym.service.impl;
/*
    Created by Trinh Khai
    Date: 31/03/2022
    Time: 16:15
*/

import com.codegym.model.MedicalDeclaration;
import com.codegym.service.IMedicalService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class MedicalService implements IMedicalService {
    private static final List<MedicalDeclaration> medicalDeclarationList = new ArrayList<>();
    static {
        medicalDeclarationList.add(new MedicalDeclaration(1, "Trịnh Khải", "2001/12/21", "Nam", "Việt Nam", "0482391283", "Máy Bay", "VN-1234", 21, "2022/03/30", "2022/03/31", null, "Đà Nẵng", "Thanh Khê", "An Khê", "21 Nguyễn Khang", "0901960757", "truongtrinhkhaidng@gmail.com"));

    }

    @Override
    public List<MedicalDeclaration> medicalDeclarationList() {
        return medicalDeclarationList;
    }

    @Override
    public void save(MedicalDeclaration medicalDeclaration) {
//        medicalDeclaration.setId(medicalDeclarationList.get(medicalDeclarationList.size() - 1).getId() + 1);
        medicalDeclaration.setId(2);
        medicalDeclarationList.add(medicalDeclaration);
    }

    @Override
    public MedicalDeclaration getMedicalDeclarationById(Integer id) {
        for (MedicalDeclaration e: medicalDeclarationList) {
            if (Objects.equals(e.getId(), id)) {
                return e;
            }
        }
        return null;
    }

    @Override
    public void updateMedicalDeclaration(MedicalDeclaration medicalDeclaration) {
        for (MedicalDeclaration e: medicalDeclarationList) {
            if (Objects.equals(e.getId(), medicalDeclaration.getId())) {
                e.setId(medicalDeclaration.getId());
                e.setName(medicalDeclaration.getName());
                e.setDateOFBirth((medicalDeclaration.getDateOFBirth()));
                e.setGender(medicalDeclaration.getGender());
                e.setNationality(medicalDeclaration.getNationality());
                e.setIdCard(medicalDeclaration.getIdCard());
                e.setVehicle(medicalDeclaration.getVehicle());
                e.setVehicleNumber(medicalDeclaration.getVehicleNumber());
                e.setChairNumber(medicalDeclaration.getChairNumber());
                e.setDepartureDay(medicalDeclaration.getDepartureDay());
                e.setEndDay(medicalDeclaration.getEndDay());
                e.setCityUsedToPass(medicalDeclaration.getCityUsedToPass());
                e.setProvince(medicalDeclaration.getProvince());
                e.setDistrict(medicalDeclaration.getDistrict());
                e.setWards(medicalDeclaration.getWards());
                e.setAddress(medicalDeclaration.getAddress());
                e.setPhoneNumber(medicalDeclaration.getPhoneNumber());
                e.setEmail(medicalDeclaration.getEmail());
            }
        }
    }
}
