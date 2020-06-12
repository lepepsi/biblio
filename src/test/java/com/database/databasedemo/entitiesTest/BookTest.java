package com.database.databasedemo.entitiesTest;

import com.database.databasedemo.Entity.Book;
import com.database.databasedemo.Repositories.BookJpaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@Transactional
public class BookTest {

    @Autowired
    private BookJpaRepository bookJpaRepository;

    /**
     * This test is written to verify the number of books saved in our database
     */
    @Test
    void anzahlBuch() {

        assertEquals(1, bookJpaRepository.findAll().size());

    }

    /**
     *This test allows us to check if we can actually save a new book in the database.
     */
    @Test
    void saveBuch() {
        Book book = new Book();
        book.setId(1);
        book.setTitel("Chevalier");
        book.setIsbn("234");
        book.setNumberInStock(5);

        bookJpaRepository.saveAndFlush(book);

        assertEquals(2, bookJpaRepository.findAll().size());
    }
}
