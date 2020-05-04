public class Apartament {
    private String location;
    private int monthlyRentCost;

    public Apartament(String loc, int rent){
        this.location=loc;
        this.monthlyRentCost=rent;
    }

    public String getLocation(){
        return this.location;
    }

    public int getMonthlyRentCost(){
        return this.monthlyRentCost;
    }

    @Override
    public String toString(){
        return "Apartment{ location = "+ this.getLocation()+ ", monthlyRentCost = "+ this.getMonthlyRentCost()+"}";
    }
}
