package Domain;
//we use singleton
public class Logger {
    private static Logger instance=new Logger();
    private Logger(){
        this.username="";
    }
    private String username=null;

    public static Logger getInstance(){
        synchronized (Logger.class){
            if(instance==null){
                instance = new Logger();
            }
        }
        return instance;
    }

    public static void logOut(){
        instance = null;
    }

    public void setUsername(String name){
        this.username=name;
    }

    public String getUsername(){
        return this.username;

    }

}
