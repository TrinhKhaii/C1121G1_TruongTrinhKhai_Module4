package library.service.impl;
/*
    Created by Trinh Khai
    Date: 25/04/2022
    Time: 22:08
*/

import library.model.LibraryCard;
import library.repositpry.ILibraryCardRepository;
import library.service.ILibraryCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class LibraryCardService implements ILibraryCardService {
    @Autowired
    private ILibraryCardRepository iLibraryCardRepository;

    @Override
    public Iterable<LibraryCard> findAll() {
        return iLibraryCardRepository.findAll();
    }

    @Override
    public Optional<LibraryCard> findById(Integer id) {
        return iLibraryCardRepository.findById(id);
    }

    @Override
    public void save(LibraryCard libraryCard) {
        iLibraryCardRepository.save(libraryCard);
    }

    @Override
    public void remove(Integer id) {
        iLibraryCardRepository.deleteById(id);
    }

    @Override
    public Page<LibraryCard> findAllByLibraryCardCodeContaining(String libraryCardCode, Pageable pageable) {
        return iLibraryCardRepository.findAllByStatusAndLibraryCardCodeContaining(true, libraryCardCode, pageable);
    }
}
