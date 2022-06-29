package org.mafideju.ISBNValidator.interfaces;

import org.mafideju.ISBNValidator.entities.Book;

public interface ExternalISBNDataService {
    public Book lookup(String isbn);
}
