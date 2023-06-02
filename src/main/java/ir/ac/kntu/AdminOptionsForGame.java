package ir.ac.kntu;

import java.util.ArrayList;
import java.util.Scanner;

public class AdminOptionsForGame {

    public  void handleGameForAdmin() {
        System.out.println("***********************************");
        System.out.println("1-Add Game");
        System.out.println("2-Edit Game");
        System.out.println("3-Remove Game");
        System.out.println("4-Back");
        System.out.println("***********************************");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please select your choice: ");
        int option = scanner.nextInt();
        switch (option) {
            case 1 -> addGame();
            case 2 -> findGameToEdit();
            case 3 -> findGameToRemove();
            case 4 -> Main.adminHandler.adminMenu();
            default -> System.out.println("Invalid choice!");
        }
    }

    public  void addGame() {
        String name, description, genre;
        double price;
        Scanner scanner = new Scanner(System.in);
        System.out.println("***********************************");
        System.out.print("Name: ");
        name = scanner.next();
        System.out.print("Description: ");
        description = scanner.next();
        genre = chooseGenre();
        System.out.print("Price: ");
        price = scanner.nextFloat();
        System.out.println("***********************************");
        Game newGame=new Game(name,description,genre,price);
        Start.games.add(newGame);
        System.out.println("Game "+name+" was added successfully :)");
        handleGameForAdmin();
    }

    public  String chooseGenre() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("***************Genre***************");
        System.out.println("1-Action     2-Strategy    3-Racing");
        System.out.println("4-Shooter    5-Sport       6-Simulation");
        System.out.println("7-Adventure  8-Survival       9-Others");
        System.out.println("***********************************");
        System.out.print("Please select your choice: ");
        int option = scanner.nextInt();
        switch (option) {
            case 1 -> {
                return "Action";
            }
            case 2 -> {
                return "Strategy";
            }
            case 3 -> {
                return "Racing";
            }
            case 4 -> {
                return "Shooter";
            }
            case 5 -> {
                return "Sport";
            }
            case 6 -> {
                return "Simulation";
            }
            case 7 -> {
                return "Adventure";
            }
            case 8 -> {
                return "Survival";
            }
            case 9 -> {
                return "Others";
            }
            default -> System.out.println("Invalid choice!");
        }
        return null;
    }

    public  void findGameToEdit(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insert the text you want to search with: ");
        String answer;
        int i=1;
        ArrayList<Integer> index=new ArrayList<>();
        ArrayList<Game> sorted = new ArrayList<>();
        answer = scanner.next();
        for (Game game : Start.games) {
            if (game.getName().startsWith(answer)) {
                sorted.add(game);
                index.add(Start.games.indexOf(game));
            }
        }
        if (sorted.isEmpty()) {
            System.out.println("No item found :(");
        }else {
            for (Game game : sorted) {
                System.out.println(i + "-" + game.getName());
                i++;
            }
            System.out.println("***********************************");
            System.out.print("Please select the game you want: ");
            int option = scanner.nextInt();
            Game editNeeded=Start.games.get(index.get(option-1));
            editGame(editNeeded);
        }
    }

    public  void editGame(Game game) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("***********************************");
        System.out.println("1-Edit name");
        System.out.println("2-Edit description");
        System.out.println("3-Edit genres");
        System.out.println("4-Edit price");
        System.out.println("5-Back");
        System.out.println("***********************************");
        System.out.print("Please select your choice: ");
        int option = scanner.nextInt();
        switch (option) {
            case 1 -> changeName(game);
            case 2 -> changeDescription(game);
            case 3 -> changeGenre(game);
            case 4 -> changePrice(game);
            case 5 -> Main.adminHandler.adminMenu();
            default -> System.out.println("Invalid choice!");
        }
    }

    public  void changeName(Game game){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter new name: ");
        String newname=scanner.nextLine();
        game.setName(newname);
        Main.adminHandler.adminMenu();
    }

    public  void changeDescription(Game game){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter new Description: ");
        String newDescription=scanner.nextLine();
        game.setDescription(newDescription);
        Main.adminHandler.adminMenu();
    }

    public  void changePrice(Game game){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter new Price: ");
        double newPrice=scanner.nextDouble();
        game.setPrice(newPrice);
        Main.adminHandler.adminMenu();
    }

    public  void changeGenre(Game game){
        String newGenre=chooseGenre();
        game.setGenres(newGenre);
        Main.adminHandler.adminMenu();
    }

    public  void findGameToRemove() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insert the text you want to search with: ");
        String answer;
        int i = 1;
        ArrayList<Integer> index = new ArrayList<>();
        ArrayList<Game> sorted = new ArrayList<>();
        answer = scanner.next();
        for (Game game : Start.games) {
            if (game.getName().startsWith(answer)) {
                sorted.add(game);
                index.add(Start.games.indexOf(game));
            }
        }
        if (sorted.isEmpty()) {
            System.out.println("No item found :(");
        } else {
            for (Game game : sorted) {
                System.out.println(i + "-" + game.getName());
                i++;
            }
            System.out.println("***********************************");
            System.out.print("Please select the game you want: ");
            int option = scanner.nextInt();
            int indexOfGame=index.get(option - 1);
            for (User user:Start.users){
                if (user.usergames.contains(Start.games.get(indexOfGame))){
                    int indexGameUser=user.usergames.indexOf(Start.games.get(indexOfGame));
                    user.usergames.remove(indexGameUser);
                }
            }
            Start.games.remove(indexOfGame);
            System.out.println("The game was successfully removed");
        }
    }


}
