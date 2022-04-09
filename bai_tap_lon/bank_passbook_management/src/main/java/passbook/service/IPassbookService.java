package passbook.service;
/*
    Created by Trinh Khai
    Date: 08/04/2022
    Time: 08:58
*/

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import passbook.model.Passbook;

import java.util.List;

public interface IPassbookService {
    List<Passbook> findAll();

    Passbook findById(Integer id);

    void save(Passbook passbook);

    void remove(Integer id);

//    Page<Passbook> findAllPassbook(Pageable pageable);

//    Page<Passbook> findPassbookByName(String keyword, Pageable pageable);
}
