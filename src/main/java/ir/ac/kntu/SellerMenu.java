package ir.ac.kntu;

import java.util.Scanner;

public class SellerMenu {
    public void sellerSignIn() {
        String usernameAsk, passwordAsk;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Username: ");
        usernameAsk = scanner.next();
        System.out.print("password: ");
        passwordAsk = scanner.next();
        if (checkForSignIN(usernameAsk, passwordAsk)) {
            Seller seller = saveSignInSeller(usernameAsk, passwordAsk);
            sellerOptions(seller);
        } else {
            System.out.println("developer does not exist");
        }
    }

    public Seller saveSignInSeller(String username, String password) {
        for (Seller seller : Start.sellers) {
            if (seller.getUsername().equals(username.trim()) && seller.getPassword().equals(password.trim())) {
                return seller;
            }
        }
        return null;
    }

    public boolean checkForSignIN(String username, String password) {
        for (Seller seller : Start.sellers) {
            if (seller.getUsername().equals(username.trim()) && seller.getPassword().equals(password.trim())) {
                return true;
            }
        }
        return false;
    }

    public void sellerOptions(Seller seller) {
        System.out.println("***********************************");
        System.out.println("1-Profile");
        System.out.println("2-Add accessories");
        System.out.println("3-Back");
        System.out.println("***********************************");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please select your choice: ");
        int option = scanner.nextInt();
        switch (option) {
            case 1:
                System.out.println("username: " + seller.getUsername());
                System.out.println("password: " + seller.getPassword());
                sellerOptions(seller);
            case 2:
                addAccessories(seller);
            case 3:
                Main.startHandler.adminOrUser();
            default:
                System.out.println("Invalid choice!");
                break;
        }
    }

    public void addAccessories(Seller seller) {
        System.out.println("***********************************");
        System.out.println("1-Monitor");
        System.out.println("2-Controller");
        System.out.println("3-Back");
        System.out.println("***********************************");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please select your choice: ");
        int option = scanner.nextInt();
        switch (option) {
            case 1:
                addMonitor(seller);
                sellerOptions(seller);
            case 2:
                addContoller(seller);
                sellerOptions(seller);
            case 3:
                sellerOptions(seller);
            default:
                System.out.println("Invalid choice!");
                break;
        }
    }

    public void addMonitor(Seller seller) {
        String name, description;
        double price, size;
        int count, refreshRate, time;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Name: ");
        name = scanner.next();
        System.out.print("Description: ");
        description = scanner.next();
        System.out.print("Price: ");
        price = scanner.nextDouble();
        System.out.print("Size: ");
        size = scanner.nextDouble();
        System.out.print("Count: ");
        count = scanner.nextInt();
        System.out.print("RefreshRate: ");
        refreshRate = scanner.nextInt();
        System.out.print("Time: ");
        time = scanner.nextInt();
        Monitor monitor = new Monitor(name, description, price, count, size, refreshRate, time);
        Start.hardWares.add(monitor);
        System.out.println("Hardware has been added successfully :)");
    }

    public void addContoller(Seller seller) {
        String name, description, type, system;
        double price;
        int count;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Name: ");
        name = scanner.next();
        System.out.print("Description: ");
        description = scanner.next();
        System.out.print("Price: ");
        price = scanner.nextDouble();
        System.out.print("Type: ");
        type = scanner.next();
        System.out.print("Count: ");
        count = scanner.nextInt();
        System.out.print("System: ");
        system = scanner.next();
        Controller controller = new Controller(name, description, price, count, system, type);
        Start.hardWares.add(controller);
        System.out.println("Hardware has been added successfully :)");
    }
}
