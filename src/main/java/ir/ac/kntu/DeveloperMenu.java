package ir.ac.kntu;

import java.util.Scanner;

public class DeveloperMenu {


    public void developerSignIn(){
        String usernameAsk, passwordAsk;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Username: ");
        usernameAsk = scanner.next();
        System.out.print("password: ");
        passwordAsk = scanner.next();
        if (checkForSignIN(usernameAsk, passwordAsk)) {
            Developer developerSignIn = saveSignInDeveloper(usernameAsk, passwordAsk);
            developerOptions(developerSignIn);
        } else {
            System.out.println("developer does not exist");
        }
    }

    public  Developer saveSignInDeveloper(String username, String password) {
        for (Developer developer : Start.developers) {
            if (developer.getUsername().equals(username.trim()) && developer.getPassword().equals(password.trim())) {
                return developer;
            }
        }
        return null;
    }

    public boolean checkForSignIN(String username, String password) {
        for (Developer developer : Start.developers) {
            if (developer.getUsername().equals(username.trim()) && developer.getPassword().equals(password.trim())) {
                return true;
            }
        }
        return false;
    }

    public void developerOptions(Developer developer){
        System.out.println("***********************************");
        System.out.println("1-Profile");
        System.out.println("2-Feedbacks");
        System.out.println("3-Scheduled events");
        System.out.println("4-Inbox ");
        System.out.println("5-Back");
        System.out.println("***********************************");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please select your choice: ");
        int option = scanner.nextInt();
        switch (option) {
            case 1:
                showProfile(developer);
                developerOptions(developer);
            case 2:
                showFeedBacks(developer);
                developerOptions(developer);
            case 3:

                break;
            case 4:

                break;
            case 5:
                Main.startHandler.adminOrUser();
                break;
            default:
                System.out.println("Invalid choice!");
                break;
        }
    }

    public void showProfile(Developer developer){
        System.out.println("Username: "+developer.getUsername());
        System.out.println("Password: "+developer.getPassword());
    }

    public void showFeedBacks(Developer developer){
        int i=1;
        for (String writer : developer.feedbacks.keySet()) {
            System.out.println(i + "-" + writer + ": " + developer.feedbacks.get(writer));
            i++;
        }
    }

}
