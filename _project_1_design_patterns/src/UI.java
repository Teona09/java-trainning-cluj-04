import Domain.*;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class UI {
    private final Service service;

    public UI(){
        service= new Service();
    }

    private void Menu(){
        System.out.println("Menu");
        System.out.println("1.Log In");
        System.out.println("2.Operations");
        System.out.println("3.Log out");
        System.out.println("4.Exit");
    }

    void run() throws IOException {
        Scanner in = new Scanner(System.in);
        String option;
        boolean ok=true;
        while(ok){
            this.Menu();
            System.out.println("option:");
            option = in.nextLine();
            switch (option){
                case "1":{
                    this.logIn();
                    break;
                }
                case "2":{
                    if(service.getIsLoggedIn())
                        this.operations();
                    else
                        System.out.println("not logged in");
                    break;
                }
                case "3":{
                    this.logOut();
                    break;
                }
                case "4":{
                    ok=false;
                    break;
                }
                default:{
                    System.out.println("not an option");
                    break;
                }
            }
        }
    }

    private void MenuOperations(){
        System.out.println("Menu Operations");
        System.out.println("1.Add");
        System.out.println("2.Show all smoothies from current user");
        System.out.println("3.Back");
    }

    private void operations() throws IOException {
        Scanner in = new Scanner(System.in);
        String option;
        boolean ok=true;
        while(ok){
            this.MenuOperations();
            System.out.println("option:");
            option = in.nextLine();
            switch (option){
                case "1":{
                    this.add();
                    break;
                }
                case "2":{
                    this.showAll();
                    break;
                }
                case "3":{
                    ok=false;
                    break;
                }
                default:{
                    System.out.println("not an option");
                    break;
                }
            }
        }
    }

    private void add() throws IOException {
        try {
            System.out.println("Basic Smoothie Recipe:");
            BufferedReader reader =
                    new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Choose fruit (forest fruits, banana, apple etc)");
            String fruit = reader.readLine();
            System.out.println("Choose something green/vegetable (spinach, celery, cucumber etc)");
            String green = reader.readLine();
            System.out.println("Choose liquid base (water, milk, apple juice etc)");
            String liquid = reader.readLine();
            Smoothie smoothie = new Basic(fruit, green, liquid);
            boolean save = false;
            System.out.println("Do you want seeds and/or sweetener?");
            System.out.println("1.none\t2.only seeds\t3. only sweetener\t4.both");
            String option = reader.readLine();
            switch (option) {
                case "1": {
                    service.add(smoothie.getIngredients() + "Price: " + smoothie.price());
                    break;
                }
                case "2": {
                    System.out.println("Choose seeds (chia, flax, hemp etc)");
                    String se = reader.readLine();
                    Seeds seeds = new Seeds(se, smoothie);
                    service.add(seeds.getIngredients() + "Price: " + seeds.price());
                    break;
                }
                case "3": {
                    System.out.println("Choose sweetener (honey, stevia etc)");
                    String sw = reader.readLine();
                    Sweetener sweetener = new Sweetener(sw, smoothie);
                    service.add(sweetener.getIngredients() + "Price: " + sweetener.price());
                    break;
                }
                case "4": {
                    System.out.println("Choose seeds (chia, flax, hemp etc)");
                    String se = reader.readLine();
                    Seeds seeds = new Seeds(se, smoothie);
                    System.out.println("Choose sweetener (honey, stevia etc)");
                    String sw = reader.readLine();
                    Sweetener sweetener = new Sweetener(sw, seeds);
                    service.add(sweetener.getIngredients() + "Price: " + sweetener.price());
                    break;
                }
                default:{
                    System.out.println("not an option, we consider you wanted 1");
                    service.add(smoothie.getIngredients() + "Price: " + smoothie.price());
                    break;
                }
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    private void showAll(){
        ArrayList<String> allOrdersFromCurrentUser = service.getOrders();
        if(!allOrdersFromCurrentUser.isEmpty()){
            for(String s: allOrdersFromCurrentUser)
                System.out.println(s);
        }
        else
            System.out.println("no orders processed by current user");
        System.out.println();
    }

    private void logIn() throws IOException {
        try{
            if(!service.getIsLoggedIn()) {
                Scanner in = new Scanner(System.in);
                System.out.println("Username: ");
                String username = in.nextLine();
                System.out.println("Password: ");
                String password = in.nextLine();
                service.logIn(username, password);
            }
            else System.out.println("already logged in");
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    private void logOut(){
        try{
            service.logOut();
            System.out.println("just logged out");
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
