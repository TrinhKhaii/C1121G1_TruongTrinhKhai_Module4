package library.controller;

import library.dto.BookDTO;
import library.dto.LibraryCardDTO;
import library.model.Book;
import library.model.LibraryCard;
import library.model.Student;
import library.service.IBookService;
import library.service.ILibraryCardService;
import library.service.IStudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Optional;

/*
    Created by Trinh Khai
    Date: 25/04/2022
    Time: 22:05
*/
@Controller
@RequestMapping(value = "/library-card")
public class LibraryCardController {
    @Autowired
    private ILibraryCardService iLibraryCardService;

    @Autowired
    private IBookService iBookService;

    @Autowired
    private IStudentService iStudentService;

    @ModelAttribute("students")
    public Iterable<Student> sendStudentList() {
        return iStudentService.findAll();
    }


    @GetMapping(value = {"", "/search"})
    public ModelAndView showLibraryCardList(@RequestParam("searchValue") Optional<String> search,
                                     @PageableDefault(value = 3) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("/library_card_list");
        String searchValue = search.orElse("");
        Page<LibraryCard> libraryCards = iLibraryCardService.findAllByLibraryCardCodeContaining(searchValue, pageable);
        modelAndView.addObject("libraryCards", libraryCards);
        modelAndView.addObject("searchValue", searchValue);
        return modelAndView;
    }

    @GetMapping(value = "/create/{id}")
    public ModelAndView showCreateForm(@PathVariable("id") Integer id) {
        Book book = iBookService.findById(id).orElse(null);
//        if (book.getQuantity() == 0) {
//            return new ModelAndView("redirect:/book");
//        }
        ModelAndView modelAndView = new ModelAndView("/borrow_book_form");
        BookDTO bookDTO = new BookDTO();
        if (book != null) {
            BeanUtils.copyProperties(book, bookDTO);
            modelAndView.addObject("bookId", book.getBookId());
            modelAndView.addObject("bookName", book.getBookName());
        }
        LibraryCardDTO libraryCardDTO = new LibraryCardDTO();
        libraryCardDTO.setBookDTO(bookDTO);
        modelAndView.addObject("libraryCardDTO", libraryCardDTO);
        return modelAndView;
    }

    @PostMapping(value = "/save")
    public String save(@Valid @ModelAttribute("libraryCardDTO") LibraryCardDTO libraryCardDTO,
                       BindingResult bindingResult,
                       @RequestParam("bookId") Integer bookId,
                       RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "/borrow_book_form";
        }
        Book book = iBookService.findById(bookId).orElse(null);
        LibraryCard libraryCard = new LibraryCard();
        BeanUtils.copyProperties(libraryCardDTO, libraryCard);
        libraryCard.setStudent(libraryCardDTO.getStudent());
        if (book != null) {
            libraryCard.setBook(book);
            book.setQuantity(book.getQuantity() - 1);
            iBookService.save(book);
        }
        iLibraryCardService.save(libraryCard);
        redirectAttributes.addFlashAttribute("callSuccessModal", true);
        return "redirect:/book";
    }

    @PostMapping(value = "/delete")
    public String delete(@RequestParam("idDelete") Integer libraryCardId) {
        LibraryCard libraryCard = iLibraryCardService.findById(libraryCardId).orElse(null);
        if (libraryCard != null) {
            libraryCard.setStatus(false);
            iLibraryCardService.save(libraryCard);
            Book book = iBookService.findById(libraryCard.getBook().getBookId()).orElse(null);
            if (book != null) {
                book.setQuantity(book.getQuantity() + 1);
                iBookService.save(book);
            }
        }
        return "redirect:/library-card";
    }
}
