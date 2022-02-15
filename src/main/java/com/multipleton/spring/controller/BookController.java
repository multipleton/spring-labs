package com.multipleton.spring.controller;

import com.multipleton.spring.dto.book.BookSearchDto;
import com.multipleton.spring.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {

    private BookService bookService;

    @Autowired
    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping("/books")
    public String books(BookSearchDto bookSearchDto, Model model) {
        model.addAttribute("bookSearchDto", bookSearchDto);
        model.addAttribute("books", bookService.searchBooks(bookSearchDto));
        return "books";
    }

}
