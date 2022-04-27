package medical_record.controller;

import medical_record.dto.MedicalRecordDTO;
import medical_record.dto.PatientDTO;
import medical_record.model.MedicalRecord;
import medical_record.model.Patient;
import medical_record.service.IMedicalRecordService;
import medical_record.service.IPatientService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/*
    Created by Trinh Khai
    Date: 26/04/2022
    Time: 21:34
*/
@Controller
@RequestMapping(value = "/medical-record")
public class MedicalRecordController {
    @Autowired
    private IMedicalRecordService iMedicalRecordService;

    @Autowired
    private IPatientService iPatientService;

    @GetMapping(value = {"", "/search"})
    public ModelAndView showLibraryCardList(@RequestParam("searchValue") Optional<String> search,
                                            @RequestParam(value = "searchStartDateValue", defaultValue = "1900-01-01", required = false) String startDate,
                                            @RequestParam(value = "searchEndDateValue", defaultValue = "3000-01-01", required = false) String endDate,
                                            @RequestParam("searchSelect") Optional<Integer> searchSelect,
                                            @RequestParam("searchDateSelect") Optional<Integer> searchDateSelect,
                                            @PageableDefault(value = 5) Pageable pageable) {
        String defaultStartDate = "1900-01-01";
        String defaultEndDate = "3000-01-01";
        ModelAndView modelAndView = new ModelAndView("/medical_record_list");
        String searchValue = search.orElse("");
        Integer searchSelectValue = searchSelect.orElse(1);
        Integer searchDateSelectValue = searchDateSelect.orElse(1);
        Page<MedicalRecord> medicalRecords = null;
        if (searchSelectValue == 1 && searchDateSelectValue == 1) {
            medicalRecords = iMedicalRecordService.findByAll(searchValue, "", "", startDate, endDate, defaultStartDate, defaultEndDate,  pageable);
        } else if (searchSelectValue == 1 && searchDateSelectValue == 2) {
            medicalRecords = iMedicalRecordService.findByAll(searchValue, "", "", defaultStartDate, defaultEndDate, startDate, endDate, pageable);
        } else if (searchSelectValue == 2 && searchDateSelectValue == 1) {
            medicalRecords = iMedicalRecordService.findByAll("", searchValue, "", startDate, endDate, defaultStartDate, defaultEndDate, pageable);
        } else if (searchSelectValue == 2 && searchDateSelectValue == 2) {
            medicalRecords = iMedicalRecordService.findByAll("", searchValue, "", defaultStartDate, defaultEndDate, startDate, endDate, pageable);
        } else if (searchSelectValue == 3 && searchDateSelectValue == 1) {
            medicalRecords = iMedicalRecordService.findByAll("", "", searchValue, startDate, endDate, defaultStartDate, defaultEndDate, pageable);
        } else if (searchSelectValue == 3 && searchDateSelectValue == 2) {
            medicalRecords = iMedicalRecordService.findByAll("", "", searchValue, defaultStartDate, defaultEndDate, startDate, endDate, pageable);
        }
        modelAndView.addObject("medicalRecords", medicalRecords);
        modelAndView.addObject("searchValue", searchValue);
        return modelAndView;
    }

    @GetMapping(value = "/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("medicalRecordDTO", new MedicalRecordDTO());
        return modelAndView;
    }

    @PostMapping(value = "/save")
    public String save(@Valid @ModelAttribute("medicalRecordDTO") MedicalRecordDTO medicalRecordDTO,
                       BindingResult bindingResult,
                       RedirectAttributes redirectAttributes) {
        new MedicalRecordDTO().validate(medicalRecordDTO, bindingResult);
        if (bindingResult.hasErrors()) {
            return "/create";
        }
        MedicalRecord medicalRecord = new MedicalRecord();
        Patient patient = new Patient();
        BeanUtils.copyProperties(medicalRecordDTO, medicalRecord);
        BeanUtils.copyProperties(medicalRecordDTO.getPatientDTO(), patient);
        medicalRecord.setPatient(patient);
        iPatientService.save(patient);
        iMedicalRecordService.save(medicalRecord);
        redirectAttributes.addFlashAttribute("callSuccessModal", true);
        return "redirect:/medical-record";
    }

    @GetMapping(value = "/edit/{id}")
    public ModelAndView showEditForm(@PathVariable("id") Integer id) {
        ModelAndView modelAndView = new ModelAndView("/edit");
        MedicalRecord medicalRecord = iMedicalRecordService.findById(id).orElse(null);
        MedicalRecordDTO medicalRecordDTO = new MedicalRecordDTO();
        PatientDTO patientDTO = new PatientDTO();
        if (medicalRecord != null) {
            BeanUtils.copyProperties(medicalRecord, medicalRecordDTO);
            BeanUtils.copyProperties(medicalRecord.getPatient(), patientDTO);
            medicalRecordDTO.setPatientDTO(patientDTO);
            modelAndView.addObject("medicalRecordDTO", medicalRecordDTO);
        }
        return modelAndView;
    }

    @PostMapping(value = "/update")
    public String update(@Valid @ModelAttribute("medicalRecordDTO") MedicalRecordDTO medicalRecordDTO,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/edit";
        }
        MedicalRecord medicalRecord = new MedicalRecord();
        Patient patient = new Patient();
        BeanUtils.copyProperties(medicalRecordDTO, medicalRecord);
        BeanUtils.copyProperties(medicalRecordDTO.getPatientDTO(), patient);
        medicalRecord.setPatient(patient);
        iPatientService.save(patient);
        iMedicalRecordService.save(medicalRecord);
        return "redirect:/medical-record";
    }

    @PostMapping(value = "/delete")
    public String delete(@RequestParam("idDelete") Integer id) {
        Optional<MedicalRecord> medicalRecordOptional = iMedicalRecordService.findById(id);
        if (medicalRecordOptional.isPresent()) {
            MedicalRecord medicalRecord = medicalRecordOptional.get();
            medicalRecord.setDeleteFlag(true);
            iMedicalRecordService.save(medicalRecord);
        }
        return "redirect:/medical-record";
    }

    @PostMapping(value = "/deleteMultiple")
    public String deleteMutiMedicalRecord(@RequestParam("idMultiple") Optional<String> idMultiple) {
        if (idMultiple.isPresent()) {
            String idMMutipleValue = idMultiple.get();
            List<String> arr = Arrays.asList(idMMutipleValue.split(","));
            iMedicalRecordService.setDeleteFlagMutiple(arr);
        }
        return "redirect:/medical-record";
    }
}
