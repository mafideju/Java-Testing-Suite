package org.mafideju.ISBNValidator.services;

import org.mafideju.ISBNValidator.entities.Book;
import org.mafideju.ISBNValidator.interfaces.ExternalISBNDataService;

public class StockManagement {

    private ExternalISBNDataService webService;
    private ExternalISBNDataService databaseService;
    public String getLocatorCode(String isbn) {
        Book book = databaseService.lookup(isbn);
        if (book == null) {
            book = webService.lookup(isbn);
        }
        StringBuilder locator = new StringBuilder();

        locator.append(isbn.substring(isbn.length() - 4));
        locator.append(book.getAuthor().substring(0, 1));
        locator.append(book.getTitle().split(" ").length);

        return locator.toString();
    }

    public ExternalISBNDataService getWebService() {
        return webService;
    }

    public void setWebService(ExternalISBNDataService webService) {
        this.webService = webService;
    }

    public ExternalISBNDataService getDatabaseService() {
        return databaseService;
    }

    public void setDatabaseService(ExternalISBNDataService databaseService) {
        this.databaseService = databaseService;
    }
}
