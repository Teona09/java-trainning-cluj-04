package Domain;

public class DomainException extends Exception{
    public DomainException(){
        System.out.println("an error occurred");
    }

    public DomainException(String ex) {
        System.out.println(ex);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}