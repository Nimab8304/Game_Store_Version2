package ir.ac.kntu;

import java.util.ArrayList;
import java.util.Scanner;

public class DeveloperMenu {


    public void developerSignIn(){
        String usernameAsk, passwordAsk;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Username: ");
        usernameAsk = scanner.next();
        System.out.print("password: ");
        passwordAsk = scanner.next();
        if (checkForSignIN(usernameAsk, passwordAsk)) {
            Developer developerSignIn = saveSignInDeveloper(usernameAsk, passwordAsk);
            developerOptions(developerSignIn);
        } else {
            System.out.println("developer does not exist");
        }
    }

    public  Developer saveSignInDeveloper(String username, String password) {
        for (Developer developer : Start.developers) {
            if (developer.getUsername().equals(username.trim()) && developer.getPassword().equals(password.trim())) {
                return developer;
            }
        }
        return null;
    }

    public boolean checkForSignIN(String username, String password) {
        for (Developer developer : Start.developers) {
            if (developer.getUsername().equals(username.trim()) && developer.getPassword().equals(password.trim())) {
                return true;
            }
        }
        return false;
    }

    public void developerOptions(Developer developer){
        System.out.println("***********************************");
        System.out.println("1-Profile");
        System.out.println("2-Feedbacks");
        System.out.println("3-Game");
        System.out.println("4-Scheduled events");
        System.out.println("5-Inbox ");
        System.out.println("6-Back");
        System.out.println("***********************************");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please select your choice: ");
        int option = scanner.nextInt();
        switch (option) {
            case 1:
                showProfile(developer);
                developerOptions(developer);
            case 2:
                showFeedBacks(developer);
                developerOptions(developer);
            case 3:
                handleGameForDeveloper(developer);
                developerOptions(developer);
                break;
            case 4:

                break;
            case 5:

                break;
            case 6:
                Main.startHandler.adminOrUser();
                break;
            default:
                System.out.println("Invalid choice!");
                break;
        }
    }

    public void showProfile(Developer developer){
        System.out.println("Username: "+developer.getUsername());
        System.out.println("Password: "+developer.getPassword());
    }

    public void showFeedBacks(Developer developer){
        int i=1;
        for (String writer : developer.feedbacks.keySet()) {
            System.out.println(i + "-" + writer + ": " + developer.feedbacks.get(writer));
            i++;
        }
    }

    public void handleGameForDeveloper(Developer developer) {
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
            case 1 -> addGame(developer);
            case 2 -> findGameToEdit(developer);
            case 3 -> findGameToRemove(developer);
            case 4 -> developerOptions(developer);
            default -> System.out.println("Invalid choice!");
        }
    }

    public void addGame(Developer developer) {
        String name, description, genre;
        double price;
        Scanner scanner = new Scanner(System.in);
        System.out.println("***********************************");
        System.out.print("Name: ");
        name = scanner.nextLine();
        System.out.print("Description: ");
        description = scanner.nextLine();
        genre = chooseGenre(developer);
        System.out.print("Price: ");
        price = scanner.nextFloat();
        System.out.println("***********************************");
        Game newGame = new Game(name, description, genre, price);
        Start.games.add(newGame);
        Game.saveGameInfos(Start.games);
        developer.developerGames.add(newGame);
        System.out.println("Game " + name + " was added successfully :)");
        developerOptions(developer);
    }

    public String chooseGenre(Developer developer) {
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

    public void findGameToEdit(Developer developer) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insert the text you want to search with: ");
        String answer;
        int i = 1;
        ArrayList<Integer> index = new ArrayList<>();
        ArrayList<Game> sorted = new ArrayList<>();
        answer = scanner.next();
        for (Game game : developer.developerGames) {
            if (game.getName().startsWith(answer)) {
                sorted.add(game);
                index.add(developer.developerGames.indexOf(game));
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
            Game editNeeded = developer.developerGames.get(index.get(option - 1));
            editGame(editNeeded,developer);
        }
    }

    public void editGame(Game game,Developer developer) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("***********************************");
        System.out.println("1-Edit name");
        System.out.println("2-Edit description");
        System.out.println("3-Edit genres");
        System.out.println("4-Edit price");
        System.out.println("5-Add Developer");
        System.out.println("6-Back");
        System.out.println("***********************************");
        System.out.print("Please select your choice: ");
        int option = scanner.nextInt();
        switch (option) {
            case 1 -> changeName(game,developer);
            case 2 -> changeDescription(game,developer);
            case 3 -> changeGenre(game,developer);
            case 4 -> changePrice(game,developer);
            case 5 -> addDeveloperToGame((BetaGames) game,developer);
            case 6 -> developerOptions(developer);
            default -> System.out.println("Invalid choice!");
        }
        Game.saveGameInfos(Start.games);
    }

    public void changeName(Game game,Developer developer) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter new name: ");
        String newname = scanner.nextLine();
        game.setName(newname);
    }

    public void changeDescription(Game game,Developer developer) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter new Description: ");
        String newDescription = scanner.nextLine();
        game.setDescription(newDescription);
    }

    public void changePrice(Game game,Developer developer) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter new Price: ");
        double newPrice = scanner.nextDouble();
        game.setPrice(newPrice);
    }

    public void changeGenre(Game game,Developer developer) {
        String newGenre = chooseGenre(developer);
        game.setGenres(newGenre);
    }

    public void findGameToRemove(Developer developer) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insert the text you want to search with: ");
        String answer;
        int i = 1;
        ArrayList<Integer> index = new ArrayList<>();
        ArrayList<Game> sorted = new ArrayList<>();
        answer = scanner.next();
        for (Game game : developer.developerGames) {
            if (game.getName().startsWith(answer)) {
                sorted.add(game);
                index.add(developer.developerGames.indexOf(game));
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
            int indexOfGame = index.get(option - 1);
            for (User user : Start.users) {
                if (user.usergames.contains(developer.developerGames.get(indexOfGame))) {
                    int indexGameUser = user.usergames.indexOf(developer.developerGames.get(indexOfGame));
                    user.usergames.remove(indexGameUser);
                }
            }
            Start.games.remove(indexOfGame);
            developer.developerGames.remove(Start.games.get(indexOfGame));
            System.out.println("The game was successfully removed");
            Game.saveGameInfos(Start.games);
        }
    }

    public void addDeveloperToGame(BetaGames game,Developer developer){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insert the username you want to search with: ");
        String answer=scanner.next();
        for (Developer developer1:Start.developers) {
            if (developer1.getUsername().equals(answer)){
                game.developers.add(developer1);
                developer1.developerGames.add(game);
            }
        }
    }

}
