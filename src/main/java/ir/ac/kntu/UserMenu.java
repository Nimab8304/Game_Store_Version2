package ir.ac.kntu;

import java.util.ArrayList;
import java.util.Scanner;

public class UserMenu {
    public  void accountOptions(User user) {
        System.out.println("***********************************");
        System.out.println("account options:");
        System.out.println("1-Profile");
        System.out.println("2-Store");
        System.out.println("3-Library");
        System.out.println("4-Friends");
        System.out.println("5-Sign out");
        System.out.println("***********************************");
        int option;
        System.out.print("Please select your choice: ");
        Scanner scanner = new Scanner(System.in);
        option = scanner.nextInt();
        switch (option) {
            case 1:
                Main.userProfileHandler.userProfile(user);
            case 2:
                Main.userStoreHandler.handleStore(user);
            case 3:
                Main.userLibraryHandler.handleLibrary(user);
            case 4:
                Main.userFriendHandler.handleFriends(user);
            case 5:
                long endTime = System.currentTimeMillis();
                long elapsedTime = (endTime - User.startTime)/1000;
                user.setPoint((int) (user.getPoint()+(elapsedTime/5)));
                System.out.println("Received Point: "+elapsedTime/5);
                Main.userHandler.userMenu();
            default:
                System.out.println("Invalid choice!");
                break;
        }
    }
}