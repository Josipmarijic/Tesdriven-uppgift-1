package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class SearchForBookTest {

    Book book1 = new Book("boken", "författare", "genre", "2007", true,99);

    @Mock
    private Library library;

    @Spy
    private Payment payment;

    @InjectMocks
    private SearchForBook searchForBook;

    @Captor
    ArgumentCaptor<Integer> intCaptor;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
        searchForBook.searchForBook();
    }

    @Test
    public void searchByTitle() {
        when(library.getListOfBooks()).thenReturn(new ArrayList<>(List.of(book1)));
        String expected = "boken";
        String actual = searchForBook.searchByTitle("bok").getBookName();
        assertEquals(expected, actual);
    }

    @Test
    public void searchByAuthor() {
        when(library.getListOfBooks()).thenReturn(new ArrayList<>(List.of(book1)));
        String expected = "författare";
        String actual = searchForBook.searchByAuthor("författare").getAuthor();
        assertEquals(expected, actual);
    }

    @Test
    public void searchByGenre() {
        when(library.getListOfBooks()).thenReturn(new ArrayList<>(List.of(book1)));
        String expected = "genre";
        String actual = searchForBook.searchByGenre("genre").getGenre();
        assertEquals(expected, actual);
    }

    @Test
    public void searchByReleaseYear() {
        when(library.getListOfBooks()).thenReturn(new ArrayList<>(List.of(book1)));
        String expected = "2007";
        String actual = searchForBook.searchByReleaseYear("2007").getReleaseYear();
        assertEquals(expected, actual);
    }

    @Test
    public void readReviews() {
        when(library.getListOfBooks()).thenReturn(new ArrayList<>(List.of(book1)));
        String expected = "";
        String actual = searchForBook.readReviews("bok");
        assertEquals(expected, actual);
    }



    @Test
    public void buyBook() {
        BuyBookRequest buyBookRequest = new BuyBookRequest("bok");
        when(library.getListOfBooks()).thenReturn(new ArrayList<>(List.of(book1)));
        searchForBook.buyBook(buyBookRequest);
        assertFalse(book1.isAvailable());
        verify(payment, times(1)).payment(intCaptor.capture());
        assertEquals(book1.getPrice(), intCaptor.getValue());
    }

}