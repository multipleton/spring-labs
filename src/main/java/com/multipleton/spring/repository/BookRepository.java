package com.multipleton.spring.repository;

import com.multipleton.spring.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface BookRepository {

    List<Book> findAll();

    Page<Book> findAllByTitleAndTagsAndAuthor_Name(String title, Set<String> tags, String name, Pageable pageable);

    List<Book> findAllByAuthor_Id(Long authorId);

    Optional<Book> findById(Long id);

    Book save(Book book);

    void deleteById(Long id);

}
