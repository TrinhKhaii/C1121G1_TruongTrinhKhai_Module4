package thi_thuc_hanh.service;
/*
    Created by Trinh Khai
    Date: 25/04/2022
    Time: 21:41
*/

import java.util.Optional;

public interface IGeneralService<T> {
    Iterable<T> findAll();

    Optional<T> findById(Integer id);

    void save(T t);

    void remove(Integer id);
}
