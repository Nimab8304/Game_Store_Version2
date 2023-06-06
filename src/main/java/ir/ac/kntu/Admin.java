package ir.ac.kntu;

import java.util.ArrayList;
import java.util.Scanner;

public class Admin {
    private String username;

    private String password;

    public Admin(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Admin() {
    }

    public void adminLogin() {
        String usernameAsk, passwordAsk;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Username: ");
        usernameAsk = scanner.next();
        System.out.print("password: ");
        passwordAsk = scanner.next();
        if (checkForSignIN(usernameAsk, passwordAsk)) {
            Admin adminSignIn = saveSignInAdmin(usernameAsk, passwordAsk);
            adminMenu(adminSignIn);
        } else {
            System.out.println("Admin does not exist");
        }

    }

    public void goBack() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you want to try again:(y/n) ");
        String answer;
        answer = scanner.next();
        if (answer.trim().equals("y")) {
            Main.startHandler.adminOrUser();
        } else if (answer.trim().equals("n")) {
            System.exit(0);
        }
    }

    public void adminMenu(Admin admin) {
        System.out.println("***********************************");
        System.out.println("1-Users");
        System.out.println("2-Games");
        System.out.println("3-Accessories");
        System.out.println("4-Profile");
        System.out.println("5-Back");
        System.out.println("***********************************");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please select your choice: ");
        int option = scanner.nextInt();
        switch (option) {
            case 1:
                Main.adminOptionForUserHandler.handleUserForAdmin(admin);
            case 2:
                Main.adminOptionsForGameHandler.handleGameForAdmin(admin);
            case 3:
                Main.adminOptionsForAccessories.findAccessoriesWithName(admin);
                break;
            case 4:
                showProfile(admin);
                adminMenu(admin);
                break;
            case 5:
                Main.startHandler.adminOrUser();
                break;
            default:
                System.out.println("Invalid choice!");
                break;
        }
    }

    public boolean checkForSignIN(String username, String password) {
        for (Admin admin : Main.startHandler.admins) {
            if (admin.getUsername().equals(username.trim()) && admin.getPassword().equals(password.trim())) {
                return true;
            }
        }
        return false;
    }

    public void showProfile(Admin admin) {
        System.out.println("Username: " + admin.getUsername());
        System.out.println("Password: " + admin.getPassword());
    }

    public Admin saveSignInAdmin(String username, String password) {
        for (Admin admin : Main.startHandler.admins) {
            if (admin.getUsername().equals(username.trim()) && admin.getPassword().equals(password.trim())) {
                return admin;
            }
        }
        return null;
    }

}
