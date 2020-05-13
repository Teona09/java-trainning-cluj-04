package Domain;

public class Seeds extends Extra {
    protected String seeds;

    public Seeds(String seeds, Smoothie sm) {
        super("Domain.Seeds: "+seeds+"; ", sm);
        this.seeds=seeds;
    }

    @Override
    public String getIngredients() {
        return smoothie.getIngredients()+"Seeds: "+ this.seeds+"; ";
    }

    @Override
    public int price() {
        return smoothie.price()+5;
    }
}
