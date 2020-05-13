package Domain;

public class Sweetener extends Extra {
    protected String sweetener;

    public Sweetener(String sweetener, Smoothie sm) {
        super("Domain.Sweetener: "+sweetener+"; ", sm);
        this.sweetener=sweetener;
    }

    @Override
    public String getIngredients() {
        return smoothie.getIngredients()+"Sweetener: "+ this.sweetener+"; ";
    }

    @Override
    public int price() {
        return smoothie.price()+2;
    }
}