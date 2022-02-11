package org.multipleton.labs.service;

import org.multipleton.labs.dto.AuthorDto;
import org.multipleton.labs.model.Author;
import org.multipleton.labs.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope("prototype")
public class AuthorService {

    @Autowired
    AuthorRepository authorRepository;

    public Author createAuthor(AuthorDto dto) {
        var author = new Author(null, dto.getName());
        return authorRepository.save(author);
    }

    public void updateAuthor(AuthorDto dto) {
        var author = authorRepository.findById(dto.getId())
                .orElseThrow(() -> new IllegalArgumentException("Author not found: " + dto.getId()));
        author.setName(dto.getName());
        authorRepository.save(author);
    }

    public void deleteAuthor(Long id) {
        authorRepository.deleteById(id);
    }

    public List<Author> findAllAuthors() {
        return authorRepository.findAll();
    }
}
