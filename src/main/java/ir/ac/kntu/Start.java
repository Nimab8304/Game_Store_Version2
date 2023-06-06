package ir.ac.kntu;

import java.util.ArrayList;
import java.util.Scanner;


public class Start {

    public static ArrayList<User> users = new ArrayList<>();

    public  ArrayList<Admin> admins = new ArrayList<>();

    public static ArrayList<Game> games=new ArrayList<>();

    public static ArrayList<HardWare> hardWares=new ArrayList<>();

    public static ArrayList<Developer> developers=new ArrayList<>();

    public static ArrayList<Seller> sellers=new ArrayList<>();

    public  void adminOrUser(){
        int option;
        Scanner scanner = new Scanner(System.in);
        System.out.println("***********************************");
        System.out.println("Login options:");
        System.out.println("1-Admin");
        System.out.println("2-User");
        System.out.println("3-Developer");
        System.out.println("4-Seller");
        System.out.println("5-Exit.");
        System.out.println("***********************************");
        System.out.print("Please select your choice: ");

        option = scanner.nextInt();
        switch (option){
            case 1:
                Main.adminHandler.adminLogin();
                break;
            case 2:
                Main.userHandler.userMenu();
                break;
            case 3:
                Main.developerMenuHandler.developerSignIn();
                break;
            case 4:
                Main.sellerMenuHandler.sellerSignIn();
                break;
            case 5:
                System.exit(0);
            default:
                System.out.println("Invalid choice!");
                break;

        }
    }
}
