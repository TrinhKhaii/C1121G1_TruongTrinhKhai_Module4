package com.codegym.controller;

import com.codegym.model.MedicalDeclaration;
import com.codegym.repository.IMedicalRepository;
import com.codegym.service.IMedicalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Arrays;
import java.util.List;

/*
    Created by Trinh Khai
    Date: 31/03/2022
    Time: 15:12
*/
@Controller
public class MedicalController {

    @Autowired
    private IMedicalService iMedicalService;

    @GetMapping(value = "/list")
    public String list(Model model) {
        List<MedicalDeclaration> medicalDeclarationList = iMedicalService.medicalDeclarationList();
        model.addAttribute("medicalDeclarationList", medicalDeclarationList);
        return "list";
    }

    @GetMapping(value = "create")
    public String showForm(Model model) {
        MedicalDeclaration medicalDeclaration = new MedicalDeclaration();
        List<String> gender = Arrays.asList("Nam", "Nữ", "Khác");
        List<String> nationality = Arrays.asList("Việt Nam", "Trung Quốc", "USA");
        List<String> vehicle = Arrays.asList("Tàu bay", "Tàu thuyền", "Ô tô", "Khác(Ghi rõ)");
        List<String> province = Arrays.asList("Hà Nội", "Đà Nẵng", "Sài gòn");
        List<String> district = Arrays.asList("Thanh Khê", "Hải Châu", "Hòa Khánh");
        List<String> wards = Arrays.asList("An Khê", "Thạc Gián");
        model.addAttribute("gender", gender);
        model.addAttribute("nationality", nationality);
        model.addAttribute("vehicle", vehicle);
        model.addAttribute("province", province);
        model.addAttribute("district", district);
        model.addAttribute("wards", wards);
        model.addAttribute("medicalDeclaration", medicalDeclaration);
        return "form";
    }

    @PostMapping(value = "create")
    public String createNewMedicalDeclaration(@ModelAttribute("medicalDeclaration") MedicalDeclaration medicalDeclaration) {
        System.out.println(medicalDeclaration);
        iMedicalService.save(medicalDeclaration);
        return "redirect:/list";
    }

    @GetMapping(value = "/update/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id,
                                 Model model) {
        MedicalDeclaration medicalDeclaration = iMedicalService.getMedicalDeclarationById(id);
        model.addAttribute("medicalDeclaration", medicalDeclaration);
        List<String> gender = Arrays.asList("Nam", "Nữ", "Khác");
        List<String> nationality = Arrays.asList("Việt Nam", "Trung Quốc", "USA");
        List<String> vehicle = Arrays.asList("Tàu bay", "Tàu thuyền", "Ô tô", "Khác(Ghi rõ)");
        List<String> province = Arrays.asList("Hà Nội", "Đà Nẵng", "Sài gòn");
        List<String> district = Arrays.asList("Thanh Khê", "Hải Châu", "Hòa Khánh");
        List<String> wards = Arrays.asList("An Khê", "Thạc Gián");
        model.addAttribute("gender", gender);
        model.addAttribute("nationality", nationality);
        model.addAttribute("vehicle", vehicle);
        model.addAttribute("province", province);
        model.addAttribute("district", district);
        model.addAttribute("wards", wards);
        return "update-form";
    }

    @PostMapping(value = "/update")
    public String update(@ModelAttribute("medicalDeclaration") MedicalDeclaration medicalDeclaration) {
        iMedicalService.updateMedicalDeclaration(medicalDeclaration);
        return "redirect:/list";
    }
}
