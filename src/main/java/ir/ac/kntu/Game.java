package ir.ac.kntu;

import java.util.HashMap;

public class Game {
    private String name;

    private String description;

    private String genres;

    private double price;

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public HashMap<String, String> comments = new HashMap<>();

    public HashMap<String, Double> rates = new HashMap<>();


    public Game(String name, String description, String genres, double price) {
        this.name = name;
        this.description = description;
        this.genres = genres;
        this.price = price;
    }


    public String getDescription() {
        return description;
    }

    public String getGenres() {
        return genres;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
}
