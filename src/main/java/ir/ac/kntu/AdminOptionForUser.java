package ir.ac.kntu;

import java.util.Scanner;

public class AdminOptionForUser {

    public  void handleUserForAdmin() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("***********************************");
        System.out.println("1-Search with username");
        System.out.println("2-Search with phone-number");
        System.out.println("3-Search with email");
        System.out.println("4-Back");
        System.out.println("***********************************");
        System.out.print("Please select your choice: ");
        int option = scanner.nextInt();
        switch (option) {
            case 1:
                findUserWithUsername();
                break;
            case 2:
                findUserWithPhoneNumber();
                break;
            case 3:
                findUserWithEmail();
                break;
            case 4:
                Main.adminHandler.adminMenu();
                break;
            default:
                System.out.println("Invalid choice!");
                break;
        }
    }

    public  void findUserWithUsername() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insert the username you want to search with: ");
        String answer;
        int index = -1;
        answer = scanner.next();
        User editneeded = null;
        for (User user : Start.users) {
            if (user.getUsername().equals(answer)) {
                editneeded = user;
                index = Start.users.indexOf(user);
            }
        }
        if (index == -1) {
            System.out.println("No item found :(");
        } else {
            if (editneeded != null) {
                userOptions(editneeded);
            }
        }
    }

    public  void userOptions(User user) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("***********************************");
        System.out.println("1-User's informations");
        System.out.println("2-Ban User");
        System.out.println("3-Edit information");
        System.out.println("4-Back");
        System.out.println("***********************************");
        System.out.print("Please select your choice: ");
        int option = scanner.nextInt();
        switch (option) {
            case 1:
                Main.userProfileHandler.showInformation(user);
                handleUserForAdmin();
                break;
            case 2:
                Start.users.remove(user);
                break;
            case 3:
                Main.userProfileHandler.editInformation(user);
                break;
            case 4:
                handleUserForAdmin();
                break;
            default:
                System.out.println("Invalid choice!");
                break;
        }
    }

    public  void findUserWithPhoneNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insert the phone-number you want to search with: ");
        String answer;
        int index = -1;
        answer = scanner.next();
        User editneeded = null;
        for (User user : Start.users) {
            if (user.getPhoneNumber().equals(answer)) {
                editneeded = user;
                index = Start.users.indexOf(user);
            }
        }
        if (index == -1) {
            System.out.println("No item found :(");
        } else {
            if (editneeded != null) {
                userOptions(editneeded);
            }
        }
    }

    public  void findUserWithEmail() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insert the Email you want to search with: ");
        String answer;
        int index = -1;
        answer = scanner.next();
        User editneeded = null;
        for (User user : Start.users) {
            if (user.getEmail().equals(answer)) {
                editneeded = user;
                index = Start.users.indexOf(user);
            }
        }
        if (index == -1) {
            System.out.println("No item found :(");
        } else {
            if (editneeded != null) {
                userOptions(editneeded);
            }
        }
    }
}
