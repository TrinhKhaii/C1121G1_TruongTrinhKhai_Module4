package borrow_books.repository;
/*
    Created by Trinh Khai
    Date: 11/04/2022
    Time: 14:23
*/

import borrow_books.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookRepository extends JpaRepository<Book, Integer> {
}
