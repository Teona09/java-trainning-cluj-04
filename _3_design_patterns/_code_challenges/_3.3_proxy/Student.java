public class Student {
    private String name;
    private int money;

    public Student(String name, int money){
        this.name=name;
        this.money=money;
    }

    public String getName(){
        return this.name;
    }

    public int getMoney(){
        return this.money;
    }

    @Override
    public String toString(){
        return "Student{ name = "+ this.getName()+ ", money = "+ this.getMoney()+"}";
    }
}
