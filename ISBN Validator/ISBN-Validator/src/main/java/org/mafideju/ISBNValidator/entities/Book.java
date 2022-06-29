package org.mafideju.ISBNValidator.entities;

public class Book {
    private String isbn;
    private String title;
    private String author;

    public Book() {

    }

    public Book(String isbn, String title, String author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public String setIsbn(String isbn) {
        return this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public String setTitle(String title) {
        return this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public String setAuthor(String author) {
        return this.author = author;
    }
}
