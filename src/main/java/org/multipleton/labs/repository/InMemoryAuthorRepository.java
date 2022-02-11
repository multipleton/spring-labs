package org.multipleton.labs.repository;

import org.multipleton.labs.model.Author;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class InMemoryAuthorRepository implements AuthorRepository {
    private final Set<Author> authors = new HashSet<>();
    private final AtomicLong lastIndex = new AtomicLong(0);

    @Override
    public List<Author> findAll() {
        return authors.stream().toList();
    }

    @Override
    public Optional<Author> findById(Long id) {
        return authors.stream()
                .filter(b -> b.getId().equals(id))
                .findFirst();
    }

    @Override
    public Author save(Author author) {
        if (author.getId() == null) {
            author.setId(lastIndex.incrementAndGet());
        }
        authors.remove(author);
        authors.add(author);
        return author;
    }

    @Override
    public void deleteById(Long id) {
        authors.stream()
                .filter(b -> b.getId().equals(id))
                .findFirst()
                .ifPresent(authors::remove);
    }
}
