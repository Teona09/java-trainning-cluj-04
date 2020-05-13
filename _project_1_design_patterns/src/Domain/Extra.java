package Domain;

//we use decorator
public abstract class Extra extends Smoothie {
    protected Smoothie smoothie;

    public Extra(String ingredients, Smoothie sm) {
        super(ingredients);
        this.smoothie=sm;
    }

    public abstract String getIngredients();
}
