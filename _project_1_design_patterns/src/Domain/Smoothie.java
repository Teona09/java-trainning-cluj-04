package Domain;

public abstract class Smoothie {
    private String ingredients;

    public Smoothie(String ingredients){
        super();
        this.ingredients=ingredients;
    }

    public String getIngredients() {
        return this.ingredients;
    }

    public abstract int price();
}
