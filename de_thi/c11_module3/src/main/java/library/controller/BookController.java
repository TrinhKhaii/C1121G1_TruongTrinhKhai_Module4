package library.controller;
/*
    Created by Trinh Khai
    Date: 25/04/2022
    Time: 21:39
*/

import library.model.Book;
import library.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping(value = "/book")
public class BookController {
    @Autowired
    private IBookService iBookService;

    @GetMapping(value = {"", "/search"})
    public ModelAndView showBookList(@RequestParam("searchValue") Optional<String> search,
                                     @PageableDefault(value = 3) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("/book_list");
        String searchValue = search.orElse("");
        Page<Book> books = iBookService.findAllByBookNameContaining(searchValue, pageable);
        modelAndView.addObject("books", books);
        modelAndView.addObject("searchValue", searchValue);
        return modelAndView;
    }
}
