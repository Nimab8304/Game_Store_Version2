package ir.ac.kntu;

public class Main {
    public static UserProfile userProfileHandler = new UserProfile();

    public static Admin adminHandler = new Admin();

    public static UserFriend userFriendHandler = new UserFriend();

    public static UserMenu userMenuHandler = new UserMenu();

    public static UserStore userStoreHandler = new UserStore();

    public static User userHandler = new User();

    public static Monitor monitorHandler = new Monitor();

    public static Controller controllerHandler = new Controller();

    public static Start startHandler = new Start();

    public static DeveloperMenu developerMenuHandler = new DeveloperMenu();

    public static UserLibrary userLibraryHandler = new UserLibrary();

    public static AdminOptionsForGame adminOptionsForGameHandler = new AdminOptionsForGame();

    public static AdminOptionForUser adminOptionForUserHandler = new AdminOptionForUser();

    public static AdminOptionsForAccessories adminOptionsForAccessories=new AdminOptionsForAccessories();

    public static void main(String[] args) {
//        Start.users = User.loadUserInfo();
//        Start.games = Game.loadGameInfo();
        Admin admin = new Admin("Nima", "123456");
        startHandler.admins.add(admin);
        Admin admin1 = new Admin("Amir", "1234567");
        startHandler.admins.add(admin1);
        Monitor monitor=new Monitor("monitor","perfect",48,5,15,144,1);
        Start.hardWares.add(monitor);
        Developer developer=new Developer("Ali","Abasi123456");
        Start.developers.add(developer);
        BetaGames betaGames=new BetaGames("Fifa24","beta","sport",10,1);
        betaGames.developers.add(developer);

        Start.games.add(betaGames);
        Controller controller=new Controller("Controller","very good",17,4,"PS5","wireless");
        Start.hardWares.add(controller);
        User user = new User("Abolfazl", "Abolfazl123456", "zxjcbhj@gmail.com", 100, "24525",20);
        Start.users.add(user);
        User user1 = new User("Shahram", "Shah123456", "zxyuybbhj@gmail.com", 130, "2125");
        Start.users.add(user1);
        Game game = new Game("Pes2017", "you can play it with your friends", "action", 30,1);
        Game game1 = new Game("Need For Speed", "looking for adrenalin", "Racing", 45,2);
        Game game2 = new Game("Counter", "A shooter game", "Shooter", 27,3);
        //user.friends.add(user1);
        Start.games.add(game);
        Start.games.add(game1);
        Start.games.add(game2);
        Game.saveGameInfos(Start.games);
        startHandler.adminOrUser();
    }
}