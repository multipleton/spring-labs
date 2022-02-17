package com.multipleton.spring.repository;

import com.multipleton.spring.model.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorRepository {

    List<Author> findAll();

    Optional<Author> findById(Long id);

    Author save(Author author);

    void deleteById(Long id);

}
