package borrow_books.service;
/*
    Created by Trinh Khai
    Date: 11/04/2022
    Time: 14:26
*/

import borrow_books.model.Book;
import borrow_books.model.LibraryCard;

import java.util.List;

public interface ILibraryCardService {
    List<LibraryCard> findAll();

    LibraryCard findById(Integer id);

    void save(LibraryCard libraryCard);

    void remove(Integer id);
}
