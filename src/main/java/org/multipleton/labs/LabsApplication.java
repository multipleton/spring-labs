package org.multipleton.labs;

import org.multipleton.labs.model.Author;
import org.multipleton.labs.model.Book;
import org.multipleton.labs.repository.AuthorRepository;
import org.multipleton.labs.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Set;

@SpringBootApplication
public class LabsApplication {

	public static void main(String[] args) {
		SpringApplication.run(LabsApplication.class, args);
	}

	@Bean
	CommandLineRunner fakeRunner(BookRepository bookRepository, AuthorRepository authorRepository) {
		return args -> {
			var authors = List.of(
					new Author(null, "Maxim"),
					new Author(null, "Egor"),
					new Author(null, "Liza")
			);
			authors.forEach(authorRepository::save);
			var books = List.of(
					new Book(null, "Lord of the rings 1", Set.of("adventure", "fantasy", "hobbit"), authors.get(0)),
					new Book(null, "Lord of the rings 2", Set.of("adventure", "fantasy", "hobbit"), authors.get(0)),
					new Book(null, "Lord of the rings 3", Set.of("adventure", "fantasy", "hobbit"), authors.get(0)),
					new Book(null, "Duna 1", Set.of("sand", "sci-fi", "worms"), authors.get(1)),
					new Book(null, "Duna 2", Set.of("sand", "sci-fi", "worms"), authors.get(1)),
					new Book(null, "Duna 3", Set.of("sand", "sci-fi", "worms"), authors.get(1)),
					new Book(null, "Call of cthulhu 1", Set.of("horror", "dark-fantasy", "monsters"), authors.get(2)),
					new Book(null, "Call of cthulhu 2", Set.of("horror", "dark-fantasy", "monsters"), authors.get(2)),
					new Book(null, "Call of cthulhu 3", Set.of("horror", "dark-fantasy", "monsters"), authors.get(2))
			);
			books.forEach(bookRepository::save);
			System.out.println();
		};
	}
}
