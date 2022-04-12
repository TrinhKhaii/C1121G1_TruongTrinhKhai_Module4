package borrow_books.service;
/*
    Created by Trinh Khai
    Date: 11/04/2022
    Time: 14:25
*/

import borrow_books.model.Book;

import java.util.List;

public interface IBookService {
    List<Book> findAll();

    Book findById(Integer id);

    void save(Book book);

    void remove(Integer id);
}
