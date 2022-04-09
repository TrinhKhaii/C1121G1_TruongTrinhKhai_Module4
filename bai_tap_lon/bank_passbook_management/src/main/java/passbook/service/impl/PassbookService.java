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

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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

    @Override
    public List<Passbook> searchByAll(String startDate, String endDate, String name) {
        List<Passbook> soTietKiemList = iPassbookRepository.findAll();
        List<Passbook> result = new ArrayList<>();
        for (Passbook ls : soTietKiemList) {
            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate date1 = LocalDate.parse(startDate, fmt);
            LocalDate date2 = LocalDate.parse(endDate, fmt);
            String day3 = ls.getStartDate();
            LocalDate date3 = LocalDate.parse(day3, fmt);
            if ((date1.isBefore(date3) || date1.equals(date3)) && (date2.isAfter(date3) || date2.equals(date3))) {
                if (ls.getCustomer().getCustomerName()  .contains(name)) {
                    result.add(ls);
                }
            }
        }
        return result;
    }

    @Override
    public List<Passbook> searchByDayStartAndDayEnd(String startDate, String endDate) {
        List<Passbook> soTietKiemList = iPassbookRepository.findAll();
        List<Passbook> result = new ArrayList<>();
        for (Passbook ls : soTietKiemList) {
            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate date1 = LocalDate.parse(startDate, fmt);
            LocalDate date2 = LocalDate.parse(endDate, fmt);
            String day3 = ls.getStartDate();
            LocalDate date3 = LocalDate.parse(day3, fmt);
            if ((date1.isBefore(date3) || date1.equals(date3)) && (date2.isAfter(date3) || date2.equals(date3))) {
                result.add(ls);
            }
        }
        return result;
    }

    @Override
    public List<Passbook> searchByDate(String date) {
        List<Passbook> soTietKiemList = iPassbookRepository.findAll();
        List<Passbook> result = new ArrayList<>();

        for (Passbook ls : soTietKiemList) {

            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate date1 = LocalDate.parse(date, fmt);
            String day2 = ls.getStartDate();
            LocalDate date2 = LocalDate.parse(day2, fmt);

            if (date1.equals(date2)) {
                result.add(ls);
            }
        }
        return result;
    }

    @Override
    public List<Passbook> searchByName(String name) {
        return iPassbookRepository.findAllByCustomer_CustomerNameContaining(name);
    }

    @Override
    public List<Passbook> searchByDateAndName(String date, String name) {
        List<Passbook> soTietKiemList = iPassbookRepository.findAll();
        List<Passbook> result = new ArrayList<>();
        for (Passbook ls : soTietKiemList) {
            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate date1 = LocalDate.parse(date, fmt);

            String day = ls.getStartDate();
            LocalDate date2 = LocalDate.parse(day, fmt);

            if (date1.equals(date2)) {
                if (ls.getCustomer().getCustomerName().contains(name)) {
                    result.add(ls);
                }
            }
        }
        return result;
    }
}
