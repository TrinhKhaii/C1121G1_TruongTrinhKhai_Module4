package borrow_books.service.impl;

import borrow_books.model.Book;
import borrow_books.repository.IBookRepository;
import borrow_books.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*
    Created by Trinh Khai
    Date: 11/04/2022
    Time: 14:26
*/
@Service
public class BookService implements IBookService {
    @Autowired
    private IBookRepository iBookRepository;

    @Override
    public List<Book> findAll() {
        return iBookRepository.findAll();
    }

    @Override
    public Book findById(Integer id) {
        return iBookRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Book book) {
        iBookRepository.save(book);
    }

    @Override
    public void remove(Integer id) {
        iBookRepository.deleteById(id);
    }
}
