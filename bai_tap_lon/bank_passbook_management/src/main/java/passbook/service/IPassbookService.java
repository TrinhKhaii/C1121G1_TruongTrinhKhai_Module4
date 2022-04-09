package passbook.service;
/*
    Created by Trinh Khai
    Date: 08/04/2022
    Time: 08:58
*/

import passbook.model.Passbook;

import java.util.List;

public interface IPassbookService {
    List<Passbook> findAll();

    Passbook findById(Integer id);

    void save(Passbook passbook);

    void remove(Integer id);

    List<Passbook> searchByAll(String startDate, String endDate, String name);

    List<Passbook> searchByDayStartAndDayEnd(String startDate, String endDate);

    List<Passbook> searchByDate(String date);

    List<Passbook> searchByName(String name);

    List<Passbook> searchByDateAndName(String date, String name);
}