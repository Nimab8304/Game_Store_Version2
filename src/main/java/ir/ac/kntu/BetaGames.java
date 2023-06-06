package ir.ac.kntu;

import java.util.ArrayList;
import java.util.HashMap;

public class BetaGames extends Game {

    public ArrayList<Developer> developers;

    public BetaGames(String name, String description, String genres, double price, int level) {
        super(name, description, genres, price, level);
        developers = new ArrayList<>();
    }

    public HashMap<String, String> comments = new HashMap<>();


}
