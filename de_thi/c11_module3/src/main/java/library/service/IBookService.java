package library.service;
/*
    Created by Trinh Khai
    Date: 25/04/2022
    Time: 21:42
*/

import library.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBookService extends IGeneralService<Book> {
    Page<Book> findAllByBookNameContaining(String bookName, Pageable pageable);
}
