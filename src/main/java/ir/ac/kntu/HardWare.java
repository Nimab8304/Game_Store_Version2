package ir.ac.kntu;

import java.util.HashMap;

public class HardWare {
    private String name;

    private String description;

    private double price;

    private int count;

    public HardWare() {

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public HashMap<String, String> comments = new HashMap<>();

    public String getDescription() {
        return description;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public HardWare(String name, String description, double price, int count) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.count = count;
    }
}
