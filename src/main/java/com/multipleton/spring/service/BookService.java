package com.multipleton.spring.service;

import com.multipleton.spring.dto.book.BookCreateDto;
import com.multipleton.spring.dto.book.BookDto;
import com.multipleton.spring.dto.book.BookSearchDto;
import com.multipleton.spring.dto.book.BookUpdateDto;
import com.multipleton.spring.model.Author;
import com.multipleton.spring.model.Book;
import com.multipleton.spring.repository.BookRepository;
import com.multipleton.spring.service.exception.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

    private final AuthorService authorService;
    private final BookRepository bookRepository;

    public BookService(AuthorService authorService, BookRepository bookRepository) {
        this.authorService = authorService;
        this.bookRepository = bookRepository;
    }

    protected Book findBook(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("could not find book by id: " + id));
    }

    public BookDto getBook(Long id) {
        return BookDto.from(findBook(id));
    }

    public BookDto createBook(BookCreateDto bookCreateDto) {
        Author author = authorService.findAuthor(bookCreateDto.getAuthorId());
        Book book = bookCreateDto.toBook(author);
        return BookDto.from(bookRepository.save(book));
    }

    public BookDto updateBook(Long id, BookUpdateDto bookUpdateDto) {
        Book book = findBook(id);
        bookUpdateDto.updateBook(book);
        return BookDto.from(bookRepository.save(book));
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    public List<BookDto> findAllBooks() {
        return bookRepository.findAll()
                .stream()
                .map(BookDto::from)
                .collect(Collectors.toList());
    }

    public List<BookDto> searchBooks(BookSearchDto dto) {
        return bookRepository.findAllByTitleAndTagsAndAuthor_Name(dto.getTitle(), dto.getTagsSet(), dto.getAuthor())
                .stream()
                .map(BookDto::from)
                .collect(Collectors.toList());
    }
}
