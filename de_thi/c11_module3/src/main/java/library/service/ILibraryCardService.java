package library.service;
/*
    Created by Trinh Khai
    Date: 25/04/2022
    Time: 22:07
*/

import library.model.LibraryCard;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ILibraryCardService extends IGeneralService<LibraryCard>{
    Page<LibraryCard> findAllByLibraryCardCodeContaining(String libraryCardCode, Pageable pageable);
}
