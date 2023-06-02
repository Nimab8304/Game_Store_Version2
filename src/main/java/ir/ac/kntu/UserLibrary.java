package ir.ac.kntu;

import java.util.ArrayList;
import java.util.Scanner;

public class UserLibrary {
    public  void handleLibrary(User user) {
        System.out.println("***********************************");
        System.out.println("Library options:");
        System.out.println("1-My games");
        System.out.println("2-Search by word");
        System.out.println("3-Search by price");
        System.out.println("4-Back");
        System.out.println("5-Exit");
        System.out.println("***********************************");
        System.out.print("Please select your choice: ");
        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();
        switch (option) {
            case 1:
                showUserGames(user);
                break;
            case 2:
                Main.userStoreHandler.searchWithWord(user, user.usergames);
                break;
            case 3:
                Main.userStoreHandler.searchWithPrice(user, user.usergames);
            case 4:
                Main.userMenuHandler.accountOptions(user);
            case 5:
                System.exit(0);
            default:
                System.out.println("Invalid choice!");
                break;
        }
    }

    public  void showUserGames(User user) {
        int i = 1;
        for (Game game : user.usergames) {
            System.out.println(i + "-" + game.getName());
            i++;
        }
        if (user.usergames.isEmpty()) {
            System.out.println("You do not have any games");
            handleLibrary(user);
        } else {
            showUserGamesInformation(user, user.usergames);
        }
    }

    public  void showUserGamesInformation(User user, ArrayList<Game> game) {
        int option = showSpecificGameInformation(user, game);
        rateAndComment(user, game.get(option - 1));
        Main.userMenuHandler.accountOptions(user);
    }

    public  int showSpecificGameInformation(User user, ArrayList<Game> game) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please select the game you want: ");
        int option = scanner.nextInt();
        System.out.println("Name: " + game.get(option - 1).getName());
        System.out.println("Description: " + game.get(option - 1).getDescription());
        System.out.println("genres: " + game.get(option - 1).getGenres());
        System.out.println("Price: " + game.get(option - 1).getPrice());
        System.out.println("Rate: " + countRates(game.get(option - 1)));
        return option;
    }

    public  double countRates(Game game) {
        double sum = 0;
        if (!game.rates.isEmpty()) {
            for (double rate : game.rates.values()) {
                sum += rate;
            }
            return sum / game.rates.size();
        }
        return sum;
    }

    public  void addRates(User user, double rate, Game game) {
        game.rates.put(user.getUsername(), rate);
    }

    public  void rateAndComment(User user, Game game) {
        System.out.println("1-Rate");
        System.out.println("2-Community");
        System.out.print("Please select your choice: ");
        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();
        switch (option) {
            case 1 -> handdleRate(user, game);
            case 2 -> showComment(user, game);
            default -> System.out.println("Invalid choice!");
        }
    }

    public  void handdleRate(User user, Game game) {
        double rate;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Rate: ");
        rate = scanner.nextDouble();
        addRates(user, rate, game);
        Main.userMenuHandler.accountOptions(user);
    }

    public  void showComment(User user, Game game) {
        Scanner scanner = new Scanner(System.in);
        int i = 1;
        if (game.comments.isEmpty()) {
            System.out.println("No comments have been registered");
            System.out.println("***********************************");
        } else {
            for (String writer : game.comments.keySet()) {
                System.out.println(i + "-" + writer + ": " + game.comments.get(writer));
                i++;
            }
        }
        System.out.print("Do you want to add a comment?(y/n) ");
        String answer = scanner.next();
        if (answer.trim().equals("y")) {
            addComments(user, game);
        } else {
            Main.userMenuHandler.accountOptions(user);
        }
    }

    public  void addComments(User user, Game game) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your comment: ");
        String comment = scanner.nextLine();
        game.comments.put(user.getUsername(), comment);
        Main.userMenuHandler.accountOptions(user);
    }
}
