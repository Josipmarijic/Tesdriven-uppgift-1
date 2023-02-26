package tdd;

public class BuyBookRequest {
    private String title;

    public BuyBookRequest(String title){
        this.title = title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
