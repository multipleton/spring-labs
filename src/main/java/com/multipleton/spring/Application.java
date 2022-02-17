package com.multipleton.spring;

import com.multipleton.spring.model.Author;
import com.multipleton.spring.model.Book;
import com.multipleton.spring.repository.AuthorRepository;
import com.multipleton.spring.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    @Scope("singleton")
    CommandLineRunner stubRunner(AuthorRepository authorRepository, BookRepository bookRepository) {
        return args -> {
            List<Author> authors = new ArrayList<>();
            authors.add(new Author(null, "Stephen King"));
            authors.add(new Author(null, "Erich Maria Remarque"));
            authors.add(new Author(null, "H. P. Lovecraft"));
            authors.forEach(authorRepository::save);
            List<Book> books = new ArrayList<>();
            Set<String> tags1 = new HashSet<>();
            tags1.add("Horror");
            tags1.add("Psychological horror");
            tags1.add("Novel");
            Set<String> tags2 = new HashSet<>();
            tags2.add("War");
            tags2.add("Concentration camp");
            tags2.add("Novel");
            Set<String> tags3 = new HashSet<>();
            tags3.add("Horror");
            tags3.add("Madness");
            tags3.add("Fantasy");
            books.add(new Book(null, "The Shining", authors.get(0), tags1));
            books.add(new Book(null, "Spark of Life", authors.get(1), tags2));
            books.add(new Book(null, "The Call of Cthulhu", authors.get(2), tags3));
            books.forEach(bookRepository::save);
        };
    }

}
