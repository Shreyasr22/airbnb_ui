package model;

public class Listing {
    private int id;
    private String title;
    private String location;
    private double price;

    public Listing(int id, String title, String location, double price) {
        this.id = id;
        this.title = title;
        this.location = location;
        this.price = price;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getLocation() { return location; }
    public double getPrice() { return price; }
}