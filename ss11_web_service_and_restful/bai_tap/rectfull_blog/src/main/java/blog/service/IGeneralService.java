package blog.service;
/*
    Created by Trinh Khai
    Date: 14/04/2022
    Time: 10:43
*/

import java.util.Optional;

public interface IGeneralService<T> {
    Iterable<T> findAll();

    Optional<T> findById(Integer id);

    T save(T t);

    void remove(Integer id);
}
