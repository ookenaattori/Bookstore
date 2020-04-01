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
import com.example.Bookstore.domain.CategoryRepository;
import com.example.Bookstore.domain.User;
import com.example.Bookstore.domain.UserRepository;


@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository repository;

    @Test
    public void findByUsernameShouldReturnUser() {
    	User user = repository.findByUsername("admin");
        assertThat(user.getUsername()).isEqualTo("admin");
    }
    
    @Test
    public void createNewUser() {
    	User user = new User("userTest", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
    	repository.save(user);
    	assertThat(user.getId()).isNotNull();
    }
    
    @Test
    public void deleteUser() {
    User user = repository.deleteById(1);
    assertThat(user).isNull();
    }

}