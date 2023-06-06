package ir.ac.kntu;

import java.util.Scanner;

public class UserProfile {
    public  void userProfile(User user) {
        System.out.println("***********************************");
        System.out.println("account options:");
        System.out.println("1-My information");
        System.out.println("2-Edit information");
        System.out.println("3-Charge wallet");
        System.out.println("4-Sign out");
        System.out.println("***********************************");
        System.out.print("Please select your choice: ");
        Scanner scanner = new Scanner(System.in);
        int userprofile = scanner.nextInt();
        switch (userprofile) {
            case 1:
                showInformation(user);
                Main.userMenuHandler.accountOptions(user);
                break;
            case 2:
                editInformation(user);
                break;
            case 3:
                chargeWallet(user);
            case 4:
                Main.userHandler.userMenu();
                break;
            default:
                System.out.println("Invalid choice!");
                break;
        }
    }

    public  void showInformation(User user) {
        System.out.println("Username: " + user.getUsername());
        System.out.println("Password: " + user.getPassword());
        System.out.println("Email: " + user.getEmail());
        System.out.println("Phone number: " + user.getPhoneNumber());
        System.out.println("Point: " + user.getPoint());
    }

    public  void editInformation(User user) {
        String usernameAsk, passwordAsk, phoneAsk, emailAsk;
        Scanner scanner = new Scanner(System.in);
        System.out.println("***********************************");
        System.out.print("Username: ");
        usernameAsk = scanner.next();
        System.out.print("password: ");
        passwordAsk = scanner.next();
        System.out.print("email: ");
        emailAsk = scanner.next();
        System.out.print("phonenumber: ");
        phoneAsk = scanner.next();
        System.out.println("***********************************");
        if (Main.userHandler.checkForSignUp(passwordAsk, emailAsk, phoneAsk)) {
            user.setUsername(usernameAsk);
            user.setPassword(passwordAsk);
            user.setEmail(emailAsk);
            user.setPhoneNumber(phoneAsk);
            System.out.println("Information has changed successfully :)");
        }
    }

    public  void chargeWallet(User user) {
        System.out.print("How much do you want charge up your account? ");
        Scanner scanner = new Scanner(System.in);
        double charge = scanner.nextInt();
        user.setWallet(charge);
        Main.userMenuHandler.accountOptions(user);
    }
}
