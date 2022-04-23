package com.multipleton.spring.service;

import com.multipleton.spring.dto.author.AuthorCreateDto;
import com.multipleton.spring.dto.author.AuthorDto;
import com.multipleton.spring.dto.author.AuthorUpdateDto;
import com.multipleton.spring.model.Author;
import com.multipleton.spring.repository.AuthorRepository;
import com.multipleton.spring.service.exception.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@Scope("prototype")
public class AuthorService {

    @Autowired
    AuthorRepository authorRepository;

    protected Author findAuthor(Long id) {
        return authorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("could not find author by id: " + id));
    }

    public AuthorDto getAuthor(Long id) {
        return AuthorDto.from(findAuthor(id));
    }

    public AuthorDto createAuthor(AuthorCreateDto dto) {
        Author author = dto.toAuthor();
        return AuthorDto.from(authorRepository.save(author));
    }

    public AuthorDto updateAuthor(Long id, AuthorUpdateDto dto) {
        Author author = findAuthor(id);
        dto.updateAuthor(author);
        return AuthorDto.from(authorRepository.save(author));
    }

    public void deleteAuthor(Long id) {
        findAuthor(id);
        authorRepository.deleteById(id);
    }

    public List<AuthorDto> findAllAuthors() {
        return authorRepository.findAll()
                .stream()
                .map(AuthorDto::from)
                .collect(Collectors.toList());
    }
}
