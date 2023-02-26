package tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import org.mockito.MockitoAnnotations;


import java.util.ArrayList;

import static org.mockito.Mockito.when;

public class BookTest {

    @Mock
    private Book bookMock;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetRatings() {
        when(bookMock.getRatings()).thenReturn((double) (5 + 4 + 3) / 3);
        Assertions.assertEquals((double) (5 + 4 + 3) / 3, bookMock.getRatings(), 0.0);
    }

    @Test
    public void testGetReview() {
        ArrayList<String> reviews = new ArrayList<>();
        reviews.add("Äskar denna bok!");
        reviews.add("Hatar denna bok!");
        when(bookMock.getReview()).thenReturn("Äskar denna bok!, Hatar denna bok!, ");
        Assertions.assertEquals("Äskar denna bok!, Hatar denna bok!, ", bookMock.getReview());
    }
}