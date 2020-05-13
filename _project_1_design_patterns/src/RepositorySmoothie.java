import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;

public class RepositorySmoothie {
    //normally a repo would do more
    //but now we only need the repo to store the orders and to write them to file

    private ArrayList<String> finalOrder;
    String fileName = "C:\\Users\\Teona Tanasa\\IdeaProjects\\_project_1_design_patterns\\out\\smoothie.txt";

    public RepositorySmoothie(){
        finalOrder=new ArrayList<String>();
    }

    public void addOrder(String order){
        finalOrder.add(order);
        this.writeToFile(order);
    }

    public ArrayList<String> getAll(){
        return finalOrder;
    }

    public void clearAfterUser(){
        //when a user logs out we want to mark the action in the file
        finalOrder.clear();
        this.writeToFile("\n---\n");
    }

    private void writeToFile(String order){
        try{
            FileWriter myWriter=new FileWriter(fileName,true);
            myWriter.write(order+"\n");
            myWriter.close();

        } catch (IOException e) {
            System.out.println("error writing to file");
            System.out.println(e);
            e.printStackTrace();
        }
    }
}
