package Units;

public class Goblin extends Unit{
    private static int count = 1;

    public Goblin() {
        super(5, 7, "Goblin-"+ count++, 1, 10);
        int random = (int) (Math.random()*3) + 2;
        setPower(getPower()*random);
        setAgility(getAgility()*random);
        setLevel(random*random);
        setGold(getGold()*random);
    }
}
