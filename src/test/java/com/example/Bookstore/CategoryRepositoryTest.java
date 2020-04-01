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


@RunWith(SpringRunner.class)
@DataJpaTest
public class CategoryRepositoryTest {

    @Autowired
    private CategoryRepository repository;

    @Test
    public void findByNameShouldReturnBook() {
        List<Category> categorys = repository.findByName("Horror");
        assertThat(categorys).hasSize(1);
        assertThat(categorys.get(0).getName()).isEqualTo("Horror");
    }
    
    @Test
    public void createNewCategory() {
    	Category category = new Category("Fantasy");
    	repository.save(category);
    	assertThat(category.getCategoryid()).isNotNull();
    }
    
    @Test
    public void deleteCategory() {
    List<Category> categorys = repository.deleteById(1);
    assertThat(categorys).isNull();
    }

}