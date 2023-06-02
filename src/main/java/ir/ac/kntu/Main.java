package ir.ac.kntu;

public class Main {
    public static UserProfile userProfileHandler = new UserProfile();
    public static Admin adminHandler = new Admin();

    public static UserFriend userFriendHandler = new UserFriend();

    public static UserMenu userMenuHandler = new UserMenu();

    public static UserStore userStoreHandler = new UserStore();

    public static User userHandler = new User();

    public static Start startHandler = new Start();

    public static UserLibrary userLibraryHandler = new UserLibrary();

    public static AdminOptionsForGame adminOptionsForGameHandler = new AdminOptionsForGame();

    public static AdminOptionForUser adminOptionForUserHandler = new AdminOptionForUser();

    public static void main(String[] args) {
        Admin admin = new Admin("Nima", "123456");
        User user = new User("Abolfazl", "Abolfazl123456", "zxjcbhj@gmail.com", 100, "24525");
        Start.users.add(user);
        User user1 = new User("Shahram", "Shah123456", "zxyuybbhj@gmail.com", 130, "2125");
        Start.users.add(user1);
        Game game = new Game("Pes2017", "you can play it with your friends", "action", 30);
        Game game1 = new Game("Need For Speed", "looking for adrenalin", "Racing", 45);
        Game game2 = new Game("Counter", "A shooter game", "Shooter", 27);
        //user.friends.add(user1);
        Start.games.add(game);
        Start.games.add(game1);
        Start.games.add(game2);
        startHandler.adminOrUser();
    }
}