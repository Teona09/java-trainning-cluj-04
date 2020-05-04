import java.util.Arrays;

public class Teacher implements ObservedSubject {

    private Observer[] students =  new Observer[0];

    @Override
    public void register(Observer obj) {
        this.students = Arrays.copyOf(this.students, this.students.length+1);
        this.students[this.students.length-1]=obj;
    }

    @Override
    public void unregister(Observer obj) {
        for(int i=0;i<students.length;i++)
            if(students[i].equals(obj)){
                int indexToDelete=i;
                System.arraycopy(this.students, indexToDelete+1,this.students,indexToDelete,this.students.length-1-indexToDelete);
                break;
            }
    }

    @Override
    public void notifyObservers(String message) {
        for(int i=0;i<students.length;i++)
            students[i].update(message);
    }

    public void teach(String topic){
        this.notifyObservers(topic);
    }
}
