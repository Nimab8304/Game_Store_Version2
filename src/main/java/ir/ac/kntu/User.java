package ir.ac.kntu;

import java.util.ArrayList;
import java.util.Scanner;
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

public class User implements Serializable{
    private String username;

    private String password;

    private String email;

    private double wallet;

    private String phoneNumber;

    private static final long serialVersionUID = 42L;

    public  ArrayList<Game> usergames = new ArrayList<>();

    public  ArrayList<HardWare> userHardWares = new ArrayList<>();

    public ArrayList<User> friends = new ArrayList<>();

    public ArrayList<User> request = new ArrayList<>();

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User() {
    }

    public String getEmail() {
        return email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public double getWallet() {
        return wallet;
    }

    public void setWallet(double wallet) {
        this.wallet = wallet;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public User(String username, String password, String email, double wallet, String phoneNumber) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.wallet = wallet;
        this.phoneNumber = phoneNumber;
    }

    public  void userMenu() {
        System.out.println("***********************************");
        System.out.println("User Menu:");
        System.out.println("1-Sign in");
        System.out.println("2-Sign up");
        System.out.println("3-Back");
        System.out.println("4-Exit.");
        System.out.println("***********************************");
        int option;
        System.out.print("Please select your choice: ");
        Scanner scanner = new Scanner(System.in);
        option = scanner.nextInt();
        switch (option) {
            case 1:
                handleSignIn();
                break;
            case 2:
                handleSignUp();
                break;
            case 3:
                Main.startHandler.adminOrUser();
            case 4:
                System.exit(0);
            default:
                System.out.println("Invalid choice!");
                break;
        }
    }


    public  void handleSignIn() {
        String usernameAsk, passwordAsk;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Username: ");
        usernameAsk = scanner.next();
        System.out.print("password: ");
        passwordAsk = scanner.next();
        if (checkForSignIN(usernameAsk, passwordAsk)) {
            User userSignedIn = saveSignInUser(usernameAsk, passwordAsk);
            saveUserInfos(Start.users);
            Main.userMenuHandler.accountOptions(userSignedIn);
        } else {
            System.out.println("user does not exist");
        }
    }

    public  void handleSignUp() {
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
        if (checkForSignUp(passwordAsk, emailAsk, phoneAsk) && checkUsername(usernameAsk)) {
            User userask = new User(usernameAsk, passwordAsk, emailAsk, 0, phoneAsk);
            Start.users.add(userask);
            System.out.println("user added successfully");
            saveUserInfos(Start.users);
            Main.adminHandler.goBack();
        } else {
            System.out.println("Sign up was not successful");
            int option;
            System.out.println("1-Try again");
            System.out.println("2-Go back");
            System.out.println("3-Exit.");
            System.out.print("Please select your choice: ");
            option = scanner.nextInt();
            switch (option) {
                case 1 -> handleSignUp();
                case 2 -> userMenu();
                case 3 -> System.exit(0);
                default -> System.out.println("Invalid choice!");
            }
        }
        //scanner.close();
    }

    public  boolean checkForSignUp(String password, String email, String phoneNumber) {
        if (!password.matches("^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9]).{8,}$")) {
            if (!password.matches("(.*)[1-9](.*)")) {
                System.out.println("Password must have at least one number");
                return false;
            }
            if (!password.matches("(.*)[A-Z](.*)")) {
                System.out.println("Password must have at least one upper case");
                return false;
            }
            if (!password.matches("(.*)[a-z](.*)")) {
                System.out.println("Password must have at least one lower case");
                return false;
            }
            if (password.length() < 8) {
                System.out.println("Password must have at least 8 character");
                return false;
            }
        }
        if (!email.matches(".+@gmail[.]{1}com")) {
            System.out.println("Email form is not acceptable");
            return false;
        }
        if (!phoneNumber.matches("[0-9]+")) {
            System.out.println("Phonenumber is not acceptable");
            return false;
        }
        return true;
    }

    public  boolean checkUsername(String username) {
        if (Start.users != null) {
            for (User user : Start.users) {
                if (user.getUsername().equals(username.trim())) {
                    System.out.println("Username already exist");
                    return false;
                }
            }
        }
        return true;
    }

    public  boolean checkForSignIN(String username, String password) {
        for (User user : Start.users) {
            if (user.getUsername().equals(username.trim()) && user.getPassword().equals(password.trim())) {
                return true;
            }
        }
        return false;
    }

    public  User saveSignInUser(String username, String password) {
        for (User user : Start.users) {
            if (user.getUsername().equals(username.trim()) && user.getPassword().equals(password.trim())) {
                return user;
            }
        }
        return null;
    }

    public static ArrayList<User> loadUserInfo() {
        ArrayList<User> users = new ArrayList<User>();
        File file = new File("users.info");
        try (FileInputStream fileInputStream = new FileInputStream(file);
             ObjectInputStream input = new ObjectInputStream(fileInputStream)) {
            while (true) {
                try {
                    //Read info for each student
                    User user = (User) input.readObject();
                    users.add(user);
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
        return users;
    }

    public static void saveUserInfos(ArrayList<User> students) {
        File file = new File("users.info");
        try (FileOutputStream fileOutputStream = new FileOutputStream(file);
             ObjectOutputStream output = new ObjectOutputStream(fileOutputStream)) {
            for (User user : Start.users) {
                try {
                    output.writeObject(user);
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
}
