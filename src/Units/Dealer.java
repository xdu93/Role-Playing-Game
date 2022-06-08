package Units;

public class Dealer implements Seller{

    @Override
    public String sell(Stuff stuff) {
        String str = "";
        if (stuff == Stuff.POTION){
            str = "potion";
        }
        return str;
    }

    enum Stuff{
        POTION
    }
}
