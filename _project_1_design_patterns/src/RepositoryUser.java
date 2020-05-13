import javafx.util.Pair;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class RepositoryUser {
    private ArrayList<Pair<String,String>> users;

    public RepositoryUser(){
        users = new ArrayList<Pair<String,String>>();

        Pair<String, String> pair1 = new Pair<>("user","user");
        Pair<String, String> pair2 = new Pair<>("ana","0000");
        Pair<String, String> pair3 = new Pair<>("dan","1111");

        users.add(pair1);
        users.add(pair2);
        users.add(pair3);

        for(Pair<String, String> currentUser: users)
            System.out.println(currentUser.getKey()+ ' ' + currentUser.getValue());
        }

    public boolean checkUser(String name, String password) {
        for(Pair<String, String> currentUser: users) {
            if (currentUser.getKey().equals(name)&&currentUser.getValue().equals(password)) {
                return true;
            }
        }
        return false;
        }
    }