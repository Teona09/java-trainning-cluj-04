package Domain;

public class Basic extends Smoothie {

    public Basic(String fruit, String green, String liquid) {
        super("Fruit: " + fruit + "; Something green: "
                + green + "; Liquid base: " + liquid + "; ");
    }

    @Override
    public int price() {
        return 15;
    }
}
