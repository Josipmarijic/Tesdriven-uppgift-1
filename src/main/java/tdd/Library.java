package tdd;

import java.util.ArrayList;

public class Library {

    private ArrayList<Book> listOfBooks;

    {
        listOfBooks = new ArrayList<>();
        Book book = new Book("boken", "författare", "genre", "2007", true,99);
        listOfBooks.add(book);
    }

    public ArrayList<Book> getListOfBooks() {
        return listOfBooks;
    }

    public void addBook(Book book) {
        listOfBooks.add(book);
    }


}
