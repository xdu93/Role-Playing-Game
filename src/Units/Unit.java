package Units;
public abstract class Unit implements Fightable{
    private int healthPoint, power, agility;
    private String name;
    private int level;
    private double gold;

    public Unit(int power, int agility, String name, int level, double gold) {
        this.healthPoint = 100;
        this.power = power;
        this.agility = agility;
        this.name = name;
        this.level = level;
        this.gold = gold;
    }

    public int getHealth() {
        return healthPoint;
    }

    public void setHealth(int healthPoint) { this.healthPoint = healthPoint; }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public double getGold() {
        return gold;
    }

    public void setGold(double gold) {
        this.gold = gold;
    }

    public void setLevel(int level){ this.level = level; }

    @Override
    public int attack(){
        int chance = (int) (Math.random()*9) + 3;
        if (agility*3 >=(int)(Math.random()*100)+1) {
            if ((agility % chance) == 3) {
                System.out.println("critical damage!!!");
                return power * 2;
            } else return power;
        }
        return 0;
    }

    @Override
    public String toString() {
        return  name +
                ", healthPoint_" + healthPoint +
                ", power_" + power +
                ", agility_" + agility +
                ", level_" + level +
                ", gold_" + gold +"\n";
    }
}
