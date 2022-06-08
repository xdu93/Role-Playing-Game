package Units;
import static Units.Dealer.Stuff.POTION;

public class Player extends Unit{

    public Player(int power, int agility, String name) {
        super(power, agility, name, 1, 100);
    }

    public String buy(){
        setGold(getGold() - 40);
        return new Dealer().sell(POTION);
    }
}
