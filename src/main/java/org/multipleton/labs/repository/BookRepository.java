package org.multipleton.labs.repository;

import org.multipleton.labs.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookRepository {

    List<Book> findBooksByAuthor(Long id);

    Optional<Book> findBookByTitle(String title);

    List<Book> findBooksByTags(List<String> tags);

    Book save(Book book);

    void deleteById(Long id);
}
