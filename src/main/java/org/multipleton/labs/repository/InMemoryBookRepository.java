package org.multipleton.labs.repository;

import org.multipleton.labs.model.Book;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public class InMemoryBookRepository implements BookRepository {
    private final Set<Book> books = new HashSet<>();

    @Override
    public List<Book> findBooksByAuthor(Long id) {
        return books.stream()
                .filter(b -> b.isAuthor(id))
                .toList();
    }

    @Override
    public Optional<Book> findBookByTitle(String title) {
        return books.stream()
                .filter(b -> b.getTitle().equals(title))
                .findFirst();
    }

    @Override
    public List<Book> findBooksByTags(List<String> tags) {
        return books.stream()
                .filter(b -> b.hasAnyTag(tags))
                .toList();
    }

    @Override
    public Book save(Book book) {
        books.remove(book);
        books.add(book);
        return book;
    }

    @Override
    public void deleteById(Long id) {
        books.stream()
                .filter(b -> b.getId().equals(id))
                .findFirst()
                .ifPresent(books::remove);
    }
}
