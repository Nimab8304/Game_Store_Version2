package ir.ac.kntu;

import java.util.ArrayList;
import java.util.Scanner;

public class UserStore {
    public void handleStore(User user) {
        System.out.println("***********************************");
        System.out.println("Store options:");
        System.out.println("1-Show all games");
        System.out.println("2-Search with words");
        System.out.println("3-Search by price");
        System.out.println("4-Back");
        System.out.println("5-Exit");
        System.out.println("***********************************");
        System.out.print("Please select your choice: ");
        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();
        switch (option) {
            case 1:
                showAllGames(user);
                break;
            case 2:
                searchWithWord(user, Start.games);
                break;
            case 3:
                searchWithPrice(user, Start.games);
            case 4:
                Main.userMenuHandler.accountOptions(user);
            case 5:
                System.exit(0);
            default:
                System.out.println("Invalid choice!");
                break;
        }
    }

    public void showAllGames(User user) {
        if (Start.games.isEmpty()) {
            System.out.println("Ask Admin to modify a game");
            Main.userMenuHandler.accountOptions(user);
        } else {
            int i = 1;
            System.out.println("***********************************");
            for (Game game : Start.games) {
                for (int j = 0; j < game.getName().length() + 4; j++) {
                    System.out.print("*");
                }
                System.out.print("\n");
                System.out.println("*" + i + "-" + game.getName() + "*");
                for (int j = 0; j < game.getName().length() + 4; j++) {
                    System.out.print("*");
                }
                System.out.print("\n");
                i++;
            }
            for (HardWare hardWare : Start.hardWares) {
                for (int j = 0; j < hardWare.getName().length() + 4; j++) {
                    System.out.print("-");
                }
                System.out.print("\n");
                System.out.println("|" + i + "-" + hardWare.getName() + "|");
                for (int j = 0; j < hardWare.getName().length() + 4; j++) {
                    System.out.print("-");
                }
                System.out.print("\n");
                i++;
            }
            System.out.println("***********************************");
            showGamesInformation(user, Start.games);
        }
    }

    public void addGameToUserAccount(User user, Game game) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you want to add this game to your account:(y/n) ");
        String answer;
        answer = scanner.next();
        if (answer.trim().equals("y")) {
            if (user.getWallet() < game.getPrice()) {
                System.out.println("The account balance is not enough");
                Main.userProfileHandler.userProfile(user);
            } else if (checkLevels(game,user)){
                user.setWallet(user.getWallet() - game.getPrice());
                user.usergames.add(game);
                System.out.println("The game has been added successfully :)");
            }else {
                System.out.println("Your points are not enough for this game :(");
            }
        } else if (answer.trim().equals("n")) {
            Main.userMenuHandler.accountOptions(user);
        }
    }

    public void addHardWareToUserAccount(User user, HardWare hardWare) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you want to add this game to your account:(y/n) ");
        String answer;
        answer = scanner.next();
        if (answer.trim().equals("y")) {
            if (user.getWallet() < hardWare.getPrice()) {
                System.out.println("The account balance is not enough");
                Main.userProfileHandler.userProfile(user);
            } else if (hardWare.getCount() == 0) {
                System.out.println("This item is not available :(");
            } else {
                user.setWallet(user.getWallet() - hardWare.getPrice());
                user.userHardWares.add(hardWare);
                System.out.println("The item has been added successfully :)");
                hardWare.setCount(hardWare.getCount() - 1);
            }
        } else if (answer.trim().equals("n")) {
            Main.userMenuHandler.accountOptions(user);
        }
    }

    public void searchWithWord(User user, ArrayList<Game> games) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insert the text you want to search with: ");
        String answer;
        int i = 1;
        ArrayList<Game> sorted = new ArrayList<>();
        answer = scanner.next();
        for (Game game : games) {
            if (game.getName().startsWith(answer)) {
                sorted.add(game);
            }
        }
        if (sorted.isEmpty()) {
            System.out.println("No item found :(");
            handleStore(user);
        } else {
            for (Game game : sorted) {
                System.out.println(i + "-" + game.getName());
                i++;
            }
            System.out.println("***********************************");
            showGamesInformation(user, sorted);
        }

    }

    public void showGamesInformation(User user, ArrayList<Game> game) {
        int option = Main.userLibraryHandler.showSpecificGameInformation(user, game);
        if (option <= Start.games.size()) {
            if (!user.usergames.contains(game.get(option - 1))) {
                System.out.println("you can buy this game");
                addGameToUserAccount(user, game.get(option - 1));
            } else {
                Main.userLibraryHandler.rateAndComment(user, game.get(option - 1));
                Main.userMenuHandler.accountOptions(user);
            }
        } else {
            option = option - Start.games.size();
            addHardWareToUserAccount(user, Start.hardWares.get(option - 1));
        }
        Main.userMenuHandler.accountOptions(user);
    }

    public void searchWithPrice(User user, ArrayList<Game> games) {
        int ceiling, floor;
        ArrayList<Game> sorted = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Insert the floor price: ");
        floor = scanner.nextInt();
        System.out.print("Insert the ceiling price: ");
        ceiling = scanner.nextInt();
        for (Game game : games) {
            if (floor <= game.getPrice() && game.getPrice() <= ceiling) {
                sorted.add(game);
            }
        }
        int i = 1;
        if (sorted.isEmpty()) {
            System.out.println("No item found :(");
            handleStore(user);
        } else {
            for (Game game : sorted) {
                System.out.println(i + "-" + game.getName());
                i++;
            }
            System.out.println("***********************************");
            showGamesInformation(user, sorted);
        }
    }

    public boolean checkLevels(Game game, User user) {
        if (game.getLevel() == 1) {
            return true;
        } else if (game.getLevel() == 2 && user.getPoint() >= 20) {
            return true;
        } else if (game.getLevel() == 3 && user.getPoint() >= 50) {
            return true;
        } else if (game.getLevel() == 4 && user.getPoint() >= 100) {
            return true;
        }
        return false;
    }
}
