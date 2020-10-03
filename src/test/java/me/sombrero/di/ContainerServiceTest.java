package me.sombrero.di;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class ContainerServiceTest {

    @Test
    public void getObject() {
        BookRepository bookRepository = ContainerService.getObject(BookRepository.class);
        assertNotNull(bookRepository);
    }

    @Test
    public void getObject_BookService() {
        BookService bookSeSrvice = ContainerService.getObject(BookService.class);
        assertNotNull(bookSeSrvice);
        assertNotNull(bookSeSrvice.bookRepository);
    }

}
