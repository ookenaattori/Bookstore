package com.example.Bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.Bookstore.domain.Book;
import com.example.Bookstore.domain.BookRepository;
import com.example.Bookstore.domain.Category;
import com.example.Bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(BookRepository repository, CategoryRepository crepository){
		return(args) -> {
			
			crepository.save(new Category("Horror"));
			crepository.save(new Category("Novel"));
			
			Book book1 = new Book("Kirjannimi", "Kirjailija", 2019, 1234, 10, crepository.findByName("Horror").get(0));
			Book book2 = new Book("Kirjannimi", "Kirjailija", 2018, 1235, 11, crepository.findByName("Horror").get(0));
			Book book3 = new Book("Kirjannimi", "Kirjailija", 2017, 1236, 12, crepository.findByName("Horror").get(0));
			
			repository.save(book1);
			repository.save(book2);
			repository.save(book3);
			
			
			};
	}

}
