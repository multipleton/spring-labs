package com.multipleton.spring.repository;

import com.multipleton.spring.model.Author;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class StubAuthorRepository implements AuthorRepository {
    private final Set<Author> authors = new HashSet<>();
    private Long index = 0L;

    @Override
    public List<Author> findAll() {
        return new ArrayList<>(authors);
    }

    @Override
    public Optional<Author> findById(Long id) {
        return authors.stream()
                .filter(author -> author.getId().equals(id))
                .findFirst();
    }

    @Override
    public Author save(Author author) {
        if (author.getId() == null) {
            author.setId(++index);
        }
        authors.remove(author);
        authors.add(author);
        return author;
    }

    @Override
    public void deleteById(Long id) {
        authors.stream()
                .filter(author -> author.getId().equals(id))
                .findFirst()
                .ifPresent(authors::remove);
    }
}
