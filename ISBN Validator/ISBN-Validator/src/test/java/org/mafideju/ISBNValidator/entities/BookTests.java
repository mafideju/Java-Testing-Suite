package org.mafideju.ISBNValidator.entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookTests {

    @Test
    void bookGetters() {
        Book book = new Book();
        String mockIsbn = book.setIsbn("0802125360");
        String mockTitle = book.setTitle("Please Kill Me: The Uncensored Oral History of Punk");
        String mockAuthor = book.setAuthor("Legs McNeil");

        String isbn = book.getIsbn();
        String title = book.getTitle();
        String author = book.getAuthor();

        assertEquals(isbn, mockIsbn);
        assertEquals(title, mockTitle);
        assertEquals(author, mockAuthor);
    }

    @Test
    void bookSetters() {
        Book book = new Book();

        String isbn = book.setIsbn("908728313X");
        String title = book.setTitle("Autumntide of the Middle Ages: A study of forms of life and thought of the fourteenth and fifteenth centuries in France and the Low Countries");
        String author = book.setAuthor("Johan Huizinga");

        assertEquals(book.getIsbn(), isbn);
        assertEquals(book.getTitle(), title);
        assertEquals(book.getAuthor(), author);
    }
}
