package tdd;


import java.util.ArrayList;


public class Book {

    private String bookName;
    private String author;
    private String genre;

    private String releaseYear;
    private boolean available;
    private int price;

    private ArrayList<Integer> raitings = new ArrayList();
    private ArrayList<String> reviews = new ArrayList();

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public Book(String bookName, String author, String genre, String releaseYear, boolean available, int price) {
        this.bookName = bookName;
        this.author = author;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.available = available;
    }

    public Book() {

    }





    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public String getReleaseYear() {
        return releaseYear;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public double getRatings() {
        double sum = 0;
        for (Integer raiting : raitings) sum += raiting;
        return sum / raitings.size();


    }

    public String getReview() {
        String review = "";
        for (String s : reviews) review += s + ", ";

        return review;

    }

    public void addRaiting(int raiting) {
        raitings.add(raiting);
    }

    public void addReview(String review) {
        reviews.add(review);
    }
}
