package com.multipleton.spring;

import com.multipleton.spring.model.Author;
import com.multipleton.spring.model.Book;
import com.multipleton.spring.repository.AuthorRepository;
import com.multipleton.spring.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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
	CommandLineRunner stubRunner(AuthorRepository authorRepository, BookRepository bookRepository) {
		return args -> {
			List<Author> authors = new ArrayList<>();
			authors.add(new Author(null, "Bob Dylan"));
			authors.forEach(authorRepository::save);
			List<Book> books = new ArrayList<>();
			Set<String> tags = new HashSet<>();
			tags.add("Horror");
			books.add(new Book(null, "Doom", authors.get(0), tags));
			books.forEach(bookRepository::save);
		};
	}

}
