package com.multipleton.spring.repository;

import com.multipleton.spring.model.Book;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class StubBookRepository implements BookRepository {
    private final Set<Book> books = new HashSet<>();
    private Long index = 0L;

    @Override
    public List<Book> findAll() {
        return new ArrayList<>(books);
    }

    @Override
    public List<Book> findAllByTitleAndTagsAndAuthor_Name(String title, Set<String> tags, String name) {
        return books.stream()
                .filter(book -> title == null || title.isEmpty() || book.getTitle().contains(title))
                .filter(book -> tags.isEmpty() || book.getTags().containsAll(tags))
                .filter(book -> name == null || name.isEmpty() || book.getAuthor().getName().contains(name))
                .collect(Collectors.toList());
    }

    @Override
    public List<Book> findAllByAuthor_Id(Long authorId) {
        return books.stream()
                .filter(book -> book.getAuthor().getId().equals(authorId))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Book> findById(Long id) {
        return books.stream()
                .filter(book -> book.getId().equals(id))
                .findFirst();
    }

    @Override
    public Book save(Book book) {
        if (book.getId() == null) {
            book.setId(++index);
        }
        deleteById(book.getId());
        books.add(book);
        return book;
    }

    @Override
    public void deleteById(Long id) {
        books.removeIf(book -> book.getId().equals(id));
    }
}
