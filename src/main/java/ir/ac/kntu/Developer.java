package ir.ac.kntu;

import java.util.ArrayList;
import java.util.HashMap;

public class Developer {
    HashMap<String,String> feedbacks=new HashMap<>();

    private String username;

    private String password;

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

    public Developer(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
