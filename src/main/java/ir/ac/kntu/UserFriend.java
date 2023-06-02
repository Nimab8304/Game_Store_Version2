package ir.ac.kntu;

import java.util.ArrayList;
import java.util.Scanner;

public class UserFriend {

    public  void handleFriends(User user) {
        System.out.println("***********************************");
        System.out.println("1-My Friends");
        System.out.println("2-Add Friend");
        System.out.println("3-Notification");
        System.out.println("4-Search");
        System.out.println("5-Back");
        System.out.println("6-Exit");
        System.out.println("***********************************");
        System.out.print("Please select your choice: ");
        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();
        switch (option) {
            case 1 -> showUserFriends(user);
            case 2 -> addFriend(user);
            case 3 -> notification(user);
            case 4 -> searchForFriend(user);
            case 5 -> Main.userMenuHandler.accountOptions(user);
            case 6 -> System.exit(0);
            default -> System.out.println("Invalid choice!");
        }
    }

    public  void showUserFriends(User user) {
        if (user.friends.isEmpty()) {
            System.out.println("You do not have any friends :(");
            Main.userMenuHandler.accountOptions(user);
        } else {
            showFriendGames(user, user.friends);
        }
    }

    public  void showFriendGames(User user, ArrayList<User> friends) {
        int i = 1;
        for (User friend : friends) {
            System.out.println(i + "-" + friend.getUsername());
            i++;
        }
        Scanner scanner = new Scanner(System.in);
        System.out.print("Choose a Friend: ");
        int option = scanner.nextInt();
        i = 1;
        if (user.friends.get(option - 1).usergames.isEmpty()) {
            System.out.println("Your friend has not bought any games yet! :(");
        } else {
            System.out.println("******Your Friend's Games******");
            for (Game game : user.friends.get(option - 1).usergames) {
                System.out.println(i + "-" + game.getName());
                i++;
            }
        }
        Main.userMenuHandler.accountOptions(user);
    }

    public  void searchForFriend(User user) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insert the text you want to search with: ");
        String answer;
        ArrayList<User> sorted = new ArrayList<>();
        answer = scanner.next();
        for (User friend : user.friends) {
            if (friend.getUsername().startsWith(answer)) {
                sorted.add(friend);
            }
        }
        if (sorted.isEmpty()) {
            System.out.println("No item found :(");
            Main.userMenuHandler.accountOptions(user);
        } else {
            showFriendGames(user, sorted);
        }

    }

    public  void addFriend(User user) {
        System.out.println("Enter username: ");
        Scanner scanner = new Scanner(System.in);
        String answer;
        answer = scanner.nextLine();
        boolean username = false;
        for (User user1 : Start.users) {
            if (user1.getUsername().trim().equals(answer.trim())) {
                username = true;
                if (username) {
                    System.out.println("Your request has been sent");
                    user1.request.add(user);
                }
            }
        }
        if (!username) {
            System.out.println("Could not find a user with this username");
        }
        Main.userMenuHandler.accountOptions(user);
    }

    public  void notification(User user) {
        if (user.request.isEmpty()) {
            System.out.println("You dont have a notification");
        } else {
            System.out.println("***Requests***");
            int i = 1;
            for (User request : user.request) {
                System.out.println(i + "-" + request.getUsername());
                i++;
            }
            System.out.println(i + "-" + "Back");
            Scanner scanner = new Scanner(System.in);
            System.out.print("Choose : ");
            int option = scanner.nextInt();
            if (option != i) {
                User newFriend = user.request.get(option - 1);
                System.out.println("1-Accept request");
                System.out.println("2-Deny request");
                System.out.print("Please select your choice: ");
                int access=scanner.nextInt();
                if (access==1) {
                    user.friends.add(newFriend);
                    newFriend.friends.add(user);
                    System.out.println(newFriend.getUsername() + " has been successfully added to your friends list");
                }
                user.request.clear();
            }
            Main.userMenuHandler.accountOptions(user);
        }
    }
}
