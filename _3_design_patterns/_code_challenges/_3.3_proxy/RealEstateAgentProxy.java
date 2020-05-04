import java.util.Arrays;

public class RealEstateAgentProxy {
    private Apartament[] apartaments= new Apartament[0];

    void represent(Apartament apartament){
        this.apartaments= Arrays.copyOf(this.apartaments, this.apartaments.length+1);
        this.apartaments[this.apartaments.length-1]=apartament;
    }

    public Apartament rent(Student student){
        Apartament rented=null;
        if(student.getName().startsWith("P")==false)
            for(int i=0;i<apartaments.length;i++)
                if(apartaments[i].getMonthlyRentCost()<=student.getMoney()){
                    rented = apartaments[i];
                    int indexToDelete=i;
                    System.arraycopy(this.apartaments, indexToDelete+1,this.apartaments,indexToDelete,this.apartaments.length-1-indexToDelete);
                    break;
                }
        return rented;
    }
}
