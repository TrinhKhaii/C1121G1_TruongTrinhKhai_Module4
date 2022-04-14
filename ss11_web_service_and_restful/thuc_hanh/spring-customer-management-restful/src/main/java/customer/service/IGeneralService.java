package customer.service;
/*
    Created by Trinh Khai
    Date: 13/04/2022
    Time: 22:10
*/

import java.util.Optional;

public interface IGeneralService<T> {
    Iterable<T> findAll();

    Optional<T> findById(Long id);

    T save(T t);

    void remove(Long id);
}
