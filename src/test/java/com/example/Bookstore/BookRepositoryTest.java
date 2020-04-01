package com.example.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.Bookstore.domain.Book;
import com.example.Bookstore.domain.BookRepository;
import com.example.Bookstore.domain.Category;


@RunWith(SpringRunner.class)
@DataJpaTest
public class BookRepositoryTest {

    @Autowired
    private BookRepository repository;

    @Test
    public void findByYearShouldReturnBook() {
        List<Book> books = repository.findByYear(2019);
        assertThat(books).hasSize(1);
        assertThat(books.get(0).getYear()).isEqualTo(2019);
    }
    
    @Test
    public void createNewBook() {
    	Book book = new Book("Mickey", "Mouse", 2020, 1234, 10, new Category("Fantasy"));
    	repository.save(book);
    	assertThat(book.getId()).isNotNull();
    }
    
    @Test
    public void deleteBook() {
    List<Book> books = repository.deleteById(3);
    assertThat(books).isNull();
    }

}