package org.multipleton.labs.service;

import org.multipleton.labs.dto.BookDto;
import org.multipleton.labs.model.Book;
import org.multipleton.labs.repository.AuthorRepository;
import org.multipleton.labs.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookService(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    public List<Book> findBooksByAuthor(String name) {
        return bookRepository.findBooksByAuthorName(name);
    }

    public Book findBookByTitle(String title) {
        return bookRepository.findBookByTitle(title)
                .orElseThrow();
    }

    public List<Book> findBooksByTags(List<String> tags) {
        return bookRepository.findBooksByTags(tags);
    }

    public Book createBook(BookDto dto) {
        var author = authorRepository.findById(dto.getAuthorId())
                .orElseThrow(() -> new IllegalArgumentException("Author not found: " + dto.getAuthorId()));
        var book = new Book(null, dto.getTitle(), dto.getTags(), author);
        return bookRepository.save(book);
    }

    public void deleteBook(Long bookId) {
        bookRepository.deleteById(bookId);
    }

    public void updateBook(BookDto dto) {
        var book = bookRepository.findById(dto.getId())
                .orElseThrow(() -> new IllegalArgumentException("Book not found: " + dto.getId()));
        book.setTitle(dto.getTitle());
        book.setTags(dto.getTags());
        bookRepository.save(book);
    }
}
