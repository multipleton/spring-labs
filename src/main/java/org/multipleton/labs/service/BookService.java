package org.multipleton.labs.service;

import org.multipleton.labs.dto.BookDto;
import org.multipleton.labs.model.Book;
import org.multipleton.labs.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> findBooksByAuthor(Long id) {
        // todo check author exists
        return bookRepository.findBooksByAuthor(id);
    }

    public Book findBookByTitle(String title) {
        return bookRepository.findBookByTitle(title)
                .orElseThrow();
    }

    public List<Book> findBooksByTags(List<String> tags) {
        return bookRepository.findBooksByTags(tags);
    }

    public Book createBook(BookDto bookDto) {
        // todo
        return null;
    }

    public void deleteBook(Long bookId) {
        // todo

    }

    public void updateBook(Book book) {
        // todo

    }
}
