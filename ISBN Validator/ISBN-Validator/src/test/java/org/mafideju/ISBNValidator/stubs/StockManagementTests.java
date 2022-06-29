package org.mafideju.ISBNValidator.stubs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mafideju.ISBNValidator.entities.Book;
import org.mafideju.ISBNValidator.interfaces.ExternalISBNDataService;
import org.mafideju.ISBNValidator.services.StockManagement;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class StockManagementTests {

    ExternalISBNDataService databaseService;
    ExternalISBNDataService webService;
    String isbn = "0226359948";
    Book mockedBook;
    StockManagement stockManagement;
    String locatorCode;

    @BeforeEach
    void setUp() {
        webService = mock(ExternalISBNDataService.class);
        databaseService = mock(ExternalISBNDataService.class);
        mockedBook = new Book(isbn, "Any Title", "Any Author");
        stockManagement = new StockManagement();
        stockManagement.setWebService(webService);
        stockManagement.setDatabaseService(databaseService);
    }

    @Test
    void getACorrectLocatorCode() {
        when(webService.lookup(anyString())).thenReturn(mockedBook);
        when(databaseService.lookup(anyString())).thenReturn(null);

        String locatorCode = stockManagement.getLocatorCode(isbn);

        verify(webService).lookup(anyString());
        verify(databaseService).lookup(anyString());
        assertEquals("9948A2", locatorCode);
    }

    @Test
    public void databaseIsUsedIfDataIsPresent() {
        when(databaseService.lookup(isbn)).thenReturn(mockedBook);

        String locatorCode = stockManagement.getLocatorCode(isbn);

        verify(databaseService).lookup(anyString());
        verify(webService, never()).lookup(anyString());
    }

    @Test
    public void webserviceIsUsedIfDatabaseIsNotPresent() {
        when(databaseService.lookup(isbn)).thenReturn(null);
        when(webService.lookup(isbn)).thenReturn(mockedBook);

        String locatorCode = stockManagement.getLocatorCode(isbn);

        verify(databaseService).lookup(isbn);
        verify(webService).lookup(isbn);
    }
}
// site.mockito.org