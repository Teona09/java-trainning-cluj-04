public class BuilderExample {
    public static void main(String[] args){
        Person pers=new Person.Builder("Mircea").setDrivingLicence(true).setIsMaried(false).build();
        System.out.println(pers);
    }
}
