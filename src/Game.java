import Units.Player;
import java.io.*;

public class Game {
    static String playerName;
    private static BufferedReader bfr;
    private static Player player = null;
    private static Battle battle = null;

    public static void main(String[] args) {
        //создание мира
        World wow = new World();
        bfr = new BufferedReader(new InputStreamReader(System.in));
        //начало игры
        System.out.println("The game downloaded!!!");

        try {
            command(wow , "start");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Player chooseType(World world, String str) {
        return world.getTypesOfPlayers().get(str);
    }

    private static void command(World world, String str) throws IOException {
        //Если это первый запуск, то мы должны создать игрока, именем будет служить первая введенная строка из консоли
        if (player == null) {
            System.out.println("Choose type of your player, enter the type according to the list bellow. " +
                    "Example enter *Elf* or *Human*");
            System.out.println("List of types: " + world.getTypesOfPlayers().keySet());

                player = chooseType(world, bfr.readLine());
            while (player == null) {
                System.out.println("Your write wrong type. Please try again");
                    player = chooseType(world, bfr.readLine());

            }

            //Ввод имени персонажа
            System.out.println("Enter your player name:");
            playerName = bfr.readLine();
            while (playerName.isEmpty()) {
                System.out.println("Your don't write the name. Please try again");
                playerName = bfr.readLine();
            }

            System.out.println("We start the journey!! \n"
                    + "Let's go " + playerName + "!\n"
                    + "You are " + player + "\n"
                    + "************************");
            player.setName(playerName);

            //Метод для вывода меню
            printWays(world);
        }
        //Варианты для команд
        switch (str) {
            case "1": {
                System.out.println("Do you want to buy *HEALTH POTION* for 50 gold? Print Yes or No.");
                command(world , bfr.readLine());
            }
            break;
            case "2": {
               try{
                   Battle.battle(player, world.getEnemies().remove((int) (Math.random()*world.getEnemies().size()-1)),
                           world);
               } catch (IndexOutOfBoundsException e) {
                   System.out.println("You kill all enemies!! You win!!");
                   command(world, "3");
                   break;
               }
                break;
            }
            case "3":
                System.exit(1);
                break;
            case "Yes":
                player.setHealth(100);
                player.setGold(player.getGold() - 50);
                System.out.println("Now: " + player);
                printWays(world);
                break;
            case "No": {
                printWays(world);
                command(world, bfr.readLine());
            }
        }
        //Снова ждем команды от пользователя
        command(world, bfr.readLine());
    }

    private static void printWays(World world) {
        System.out.println("Choose the way, according to the list below:");
        System.out.println(world.getWays());
    }
}
