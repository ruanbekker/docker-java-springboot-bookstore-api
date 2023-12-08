// Purpose: To test the repository layer (data access logic).
package com.bookstore.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import com.bookstore.model.Book;
import com.bookstore.repository.BookRepository;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ActiveProfiles("test")
public class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Test
    public void whenSaveBook_thenRetrieveBook() {
        Book savedBook = bookRepository.save(new Book("Test Title", "Test Author"));
        assertNotNull(savedBook.getId());
        assertEquals("Test Title", savedBook.getTitle());
    }
}

