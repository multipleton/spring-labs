package com.multipleton.spring.controller.rest;

import com.multipleton.spring.dto.author.AuthorCreateDto;
import com.multipleton.spring.dto.author.AuthorDto;
import com.multipleton.spring.dto.author.AuthorUpdateDto;
import com.multipleton.spring.dto.book.BookDto;
import com.multipleton.spring.service.AuthorService;
import com.multipleton.spring.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class AuthorRestController {

    private final AuthorService authorService;
    private final BookService bookService;

    public AuthorRestController(AuthorService authorService, BookService bookService) {
        this.authorService = authorService;
        this.bookService = bookService;
    }

    @GetMapping("/authors")
    public List<AuthorDto> getAllAuthors() {
        return authorService.findAllAuthors();
    }

    @GetMapping("/authors/{authorId}")
    public AuthorDto getAuthor(@PathVariable Long authorId) {
        return authorService.getAuthor(authorId);
    }

    @PostMapping("/authors")
    public AuthorDto createAuthor(AuthorCreateDto dto) {
        return authorService.createAuthor(dto);
    }

    @PutMapping("/authors/{authorId}")
    public AuthorDto updateAuthor(@PathVariable Long authorId, AuthorUpdateDto dto) {
        return authorService.updateAuthor(authorId, dto);
    }

    @DeleteMapping("/authors/{authorId}")
    public void deleteAuthor(@PathVariable Long authorId) {
        authorService.deleteAuthor(authorId);
    }

    @GetMapping("/authors/{authorId}/books")
    public List<BookDto> getAuthorBooks(@PathVariable Long authorId) {
        return bookService.findBooksByAuthorId(authorId);
    }

}
