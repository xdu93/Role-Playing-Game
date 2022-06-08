package Units;

public class Skull extends Unit{
    private static int count = 1;
    public Skull() {
        super(7, 5, "Skull-"+ count++, 1, 10);
        int random = (int) (Math.random()*3) + 2;
        setPower(getPower()*random);
        setAgility(getAgility()*random);
        setLevel(random*random);
        setGold(getGold()*random);
    }
}
