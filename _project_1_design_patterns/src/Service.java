import Domain.Logger;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Service {
    private final RepositorySmoothie orders;
    private final RepositoryUser users;
    private Logger currentUser;
    private boolean isLoggedIn = false;

    public Service(){
        orders = new RepositorySmoothie();
        users = new RepositoryUser();
    }

    public void add(String order){
        LocalDateTime dateTime=LocalDateTime.now(); //we use date&time to remember of our orders
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        String orderTime = dateTime.format(formatter);
        String fullOrder ="Smoothie order -> "+ order+" | Processed by _"+
                currentUser.getUsername()+ "_ at " + orderTime;
        System.out.println(fullOrder);
        orders.addOrder(fullOrder);
    }

    public ArrayList<String> getOrders(){
        return orders.getAll();
    }

    public void logIn(String name, String password) throws Exception {
        if(users.checkUser(name,password)){
            this.isLoggedIn=true;
            currentUser = Logger.getInstance();
            currentUser.setUsername(name);
        }
        else
            throw new Exception("invalid username and/or password");
        //Logger user2 =Logger.getInstance();
        //System.out.println(user2.getUsername()); // it will print parameter name
    }

    public void setIsLoggedIn(boolean value){
        this.isLoggedIn=value;
    }

    public boolean getIsLoggedIn(){
        return this.isLoggedIn;
    }

    public void logOut() throws Exception {
        if(this.isLoggedIn) {
            setIsLoggedIn(false);
            Logger.logOut();
            orders.clearAfterUser();
        }
        else
            throw new Exception("not logged in");
    }

}
