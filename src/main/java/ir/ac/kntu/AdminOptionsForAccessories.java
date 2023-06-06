package ir.ac.kntu;

import java.util.Scanner;

public class AdminOptionsForAccessories {

    public void findAccessoriesWithName(Admin admin) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insert the name you want to search with: ");
        String answer;
        int index = -1;
        answer = scanner.next();
        HardWare editneeded = null;
        for (HardWare hardWare : Start.hardWares) {
            if (hardWare.getName().equals(answer)) {
                editneeded = hardWare;
                index = Start.hardWares.indexOf(hardWare);
            }
        }
        if (index == -1) {
            System.out.println("No item found :(");
        } else {
            if (editneeded != null) {
                hardWareOptions(editneeded,admin);
            }
        }
    }

    public void hardWareOptions(HardWare hardWare,Admin admin) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("***********************************");
        System.out.println("1-Hardware's informations");
        System.out.println("2-Remove hardware");
        System.out.println("3-Edit information");
        System.out.println("4-Back");
        System.out.println("***********************************");
        System.out.print("Please select your choice: ");
        int option = scanner.nextInt();
        switch (option) {
            case 1:
                hardWareInformation(hardWare);
                Main.adminHandler.adminMenu(admin);
                break;
            case 2:
                Start.hardWares.remove(hardWare);
                System.out.println("Hardware was removed successfully");
                Main.adminHandler.adminMenu(admin);
                break;
            case 3:
                editInformation(hardWare);
                Main.adminHandler.adminMenu(admin);
                break;
            case 4:
                Main.adminHandler.adminMenu(admin);
                break;
            default:
                System.out.println("Invalid choice!");
                break;
        }
    }

    public void hardWareInformation(HardWare hardWare) {
        if (hardWare instanceof Monitor) {
            System.out.println("Name: " + hardWare.getName());
            System.out.println("Description: " + hardWare.getDescription());
            System.out.println("Price: " + hardWare.getPrice());
            System.out.println("Available: " + hardWare.getCount());
            System.out.println("Size: " + ((Monitor) hardWare).getSize());
            System.out.println("Refresh Rate: " + ((Monitor) hardWare).getRefreshRate());
            System.out.println("Response Time: " + ((Monitor) hardWare).getTime());
        } else if (hardWare instanceof Controller) {
            System.out.println("Name: " + hardWare.getName());
            System.out.println("Description: " + hardWare.getDescription());
            System.out.println("Price: " + hardWare.getPrice());
            System.out.println("Available: " + hardWare.getCount());
            System.out.println("System: " + ((Controller) hardWare).getSystem());
            System.out.println("Type: " + ((Controller) hardWare).getType());
        }
    }

    public void editInformation(HardWare hardWare) {
        String name, description;
        int price;
        int count;
        Scanner scanner = new Scanner(System.in);
        System.out.println("***********************************");
        System.out.print("Name: ");
        name = scanner.next();
        System.out.print("Description: ");
        description = scanner.next();
        System.out.print("Price: ");
        price = scanner.nextInt();
        System.out.print("Available: ");
        count = scanner.nextInt();
        hardWare.setName(name);
        hardWare.setDescription(description);
        hardWare.setCount(count);
        hardWare.setPrice(price);
        if (hardWare instanceof Monitor){
            int refreshRate,time;
            double size;
            System.out.print("RefreshRate: ");
            refreshRate = scanner.nextInt();
            System.out.print("Response time: ");
            time = scanner.nextInt();
            System.out.print("Size: ");
            size = scanner.nextDouble();
            ((Monitor) hardWare).setTime(time);
            ((Monitor) hardWare).setSize(size);
            ((Monitor) hardWare).setRefreshRate(refreshRate);
        }else if (hardWare instanceof Controller){
            String system,type;
            System.out.print("System: ");
            system = scanner.next();
            System.out.print("Type: ");
            type = scanner.next();
            ((Controller) hardWare).setType(type);
            ((Controller) hardWare).setSystem(type);
        }
        System.out.println("Information has changed successfully :)");

    }
}
