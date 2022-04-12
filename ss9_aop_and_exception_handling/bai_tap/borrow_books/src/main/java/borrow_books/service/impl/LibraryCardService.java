package borrow_books.service.impl;

import borrow_books.model.LibraryCard;
import borrow_books.repository.ILibraryRepository;
import borrow_books.service.ILibraryCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*
    Created by Trinh Khai
    Date: 11/04/2022
    Time: 14:26
*/
@Service
public class LibraryCardService implements ILibraryCardService {
    @Autowired
    private ILibraryRepository iLibraryRepository;
    @Override
    public List<LibraryCard> findAll() {
        return iLibraryRepository.findAll();
    }

    @Override
    public LibraryCard findById(Integer id) {
        return iLibraryRepository.findById(id).orElse(null);
    }

    @Override
    public void save(LibraryCard libraryCard) {
        iLibraryRepository.save(libraryCard);
    }

    @Override
    public void remove(Integer id) {
        iLibraryRepository.deleteById(id);
    }
}
