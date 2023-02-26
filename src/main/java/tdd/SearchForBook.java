package tdd;

import java.util.ArrayList;

public class SearchForBook {
    private Book bookNotFound;
    private Library library;
    private Payment payment;



    public void searchForBook() {
        this.bookNotFound = new Book();
        this.bookNotFound.setBookName("Book not found");
        this.library = new Library();
        this.payment = new Payment();

    }


    public Book searchByTitle(String searchWord) {
        for (Book i : library.getListOfBooks()) {
            if (i.getBookName().contains(searchWord)) {
                return i;
            }
        }
        return bookNotFound;

    }

    public Book searchByAuthor(String searchWord) {
        for (Book i : library.getListOfBooks()) {
            if (i.getAuthor().equalsIgnoreCase(searchWord)) return i;
        }
        return bookNotFound;
    }

    public Book searchByGenre(String searchWord) {
        for (Book i : library.getListOfBooks()) {
            if (i.getGenre().equalsIgnoreCase(searchWord)) return i;
        }
        return bookNotFound;
    }

    public Book searchByReleaseYear(String searchWord) {
        for (Book i : library.getListOfBooks()) {
            if (i.getReleaseYear().equals(searchWord)) return i;
        }
        return bookNotFound;
    }

    public String readReviews(String searchWord) {
        return searchByTitle(searchWord).getReview();
    }

    public double showAvrageRaiting(String serachWord) {
        return searchByTitle(serachWord).getRatings();
    }

   public void buyBook(BuyBookRequest buyBookRequest){
        Book bookTitle = searchByTitle(buyBookRequest.getTitle());
        if (bookTitle.isAvailable()){
            bookTitle.setAvailable(false);
            payment.payment(bookTitle.getPrice());
        }
   }



}
