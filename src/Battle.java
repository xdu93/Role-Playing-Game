import Units.*;

public class Battle {

    public static void battle(Player player, Unit enemy, World world) {
        Runnable runnable = () -> {
            int step = 1;
            boolean flagBattleEnd = false;
            while (!flagBattleEnd){
                System.out.println("******Step_"  + step + "******");
                if (step++ % 2 == 0) {
                    flagBattleEnd = hit(enemy, player, world);
                } else {
                    flagBattleEnd = hit(player, enemy, world);
                }
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }

    private static boolean hit(Unit attacker, Unit defender, World world) {
            int hitPower = attacker.attack();
            int defenderHP = defender.getHealth() - hitPower;
            if (hitPower != 0){
                if (hitPower >= defender.getHealth() && attacker instanceof Player){
                    System.out.printf("%s - hit, %d - hit power.\n", attacker.getName(), hitPower);
                    System.out.printf("%s died.\n", defender.getName());
                    System.out.printf(String.format("%s! You got %d exp and %.2f gold\n",attacker.getName() ,
                            defender.getLevel(), defender.getGold()));
                    attacker.setLevel(attacker.getLevel() + defender.getLevel());
                    attacker.setGold(attacker.getGold() + defender.getGold());
                    System.out.println("Now: " + attacker);

                    System.out.println("Choose the way, according to the list below:");
                    System.out.println(world.getWays());
                    return true;
                } else {
                    System.out.printf("%s - made hit, %d - hit power.\n", attacker.getName(), hitPower);
                    System.out.printf("%s have %d health point left.\n", defender.getName(), defenderHP);
                }
            } else {
                System.out.printf("%s miss..\n", attacker.getName());
            }
        if (defenderHP <= 0 && defender instanceof Player) {
            System.out.println("You are died. Game over...");
            System.exit(1);
            return true;
        } else {
            //если защищающийся не повержен, то мы устанавливаем ему новый уровень здоровья
            defender.setHealth(defenderHP);
            return false;
        }
    }

    interface FightCallback {
        void fightWin();
        void fightLost();
    }
}
