package ir.ac.kntu;

import java.util.HashMap;
import java.io.Serializable;
import java.util.HashMap;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;
import java.io.IOException;
import java.io.Serializable;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.EOFException;

public class Game implements Serializable {
    private String name;

    private String description;

    private String genres;

    private double price;

    private int level;

    private static final long serialVersionUID = 42L;

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


    public Game(String name, String description, String genres, double price,int level) {
        this.name = name;
        this.description = description;
        this.genres = genres;
        this.price = price;
        this.level=level;
    }

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

    public static ArrayList<Game> loadGameInfo() {
        ArrayList<Game> games = new ArrayList<Game>();
        File file = new File("games.info");
        try (FileInputStream fileInputStream = new FileInputStream(file);
             ObjectInputStream input = new ObjectInputStream(fileInputStream)) {
            while (true) {
                try {
                    //Read info for each student
                    Game game = (Game) input.readObject();
                    games.add(game);
                } catch (EOFException e) {
                    //Reaching end of file
                    break;
                } catch (Exception e) {
                    System.out.println("Problem with some of the records in the student data file");
                    System.out.println(e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println("No previous data for students has been saved.");
        }
        return games;
    }

    public static void saveGameInfos(ArrayList<Game> games) {
        File file = new File("games.info");
        try (FileOutputStream fileOutputStream = new FileOutputStream(file);
             ObjectOutputStream output = new ObjectOutputStream(fileOutputStream)) {
            for (Game game : Start.games) {
                try {
                    output.writeObject(game);
                } catch (IOException e) {
                    System.out.println("(Student::saveStudentInfos): " +
                            "An error occurred while trying to save info");
                    System.out.println(e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println("(Student::saveStudentInfos): " +
                    "An error occurred while trying to save info");
            System.out.println(e.getMessage());
        }
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
