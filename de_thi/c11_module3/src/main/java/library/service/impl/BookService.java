package library.service.impl;
/*
    Created by Trinh Khai
    Date: 25/04/2022
    Time: 21:42
*/

import library.model.Book;
import library.repositpry.IBookRepository;
import library.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class BookService implements IBookService {
    @Autowired
    private IBookRepository iBookRepository;

    @Override
    public Iterable<Book> findAll() {
        return iBookRepository.findAll();
    }

    @Override
    public Optional<Book> findById(Integer id) {
        return iBookRepository.findById(id);
    }

    @Override
    public void save(Book book) {
        iBookRepository.save(book);
    }

    @Override
    public void remove(Integer id) {
        iBookRepository.deleteById(id);
    }

    @Override
    public Page<Book> findAllByBookNameContaining(String bookName, Pageable pageable) {
        return iBookRepository.findAllByBookNameContaining(bookName, pageable);
    }
}
