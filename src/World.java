import Units.*;

import java.util.*;

public class World {

    //Юниты
    private final Map<String, Player> typesOfPlayers  = new HashMap<>();
    private List<Unit> enemies = new ArrayList<>();
    private Dealer dealer = new Dealer();
    private final Map<Integer, String> ways = new HashMap<>();
    private Map<String, List<Unit>> action = new HashMap<>();

    //Конструктор мира
    public World() {
        //Типы игроков
        typesOfPlayers.put("Human", new Player(22, 28, "Human"));
        typesOfPlayers.put("Magician", new Player(20, 25, "Magician"));
        typesOfPlayers.put("Elf", new Player(18, 32, "Elf"));
        typesOfPlayers.put("Orc", new Player(30, 18, "Orc"));

        //Создание гоблинов
        for (int i = 0; i < 4; i++) {
            enemies.add(new Goblin());
        }

        //Создание скелетов
        for (int i = 0; i < 3; i++) {
            enemies.add(new Skull());
        }

        //Направления
        ways.put(1, "Dealer");
        ways.put(2, "Dark forest");
        ways.put(3, "Exit");
    }

    public Map<String, Player> getTypesOfPlayers() {
        return typesOfPlayers;
    }

    public Map<Integer, String> getWays() {
        return ways;
    }

    public List<Unit> getEnemies() { return enemies; }

    public Dealer getDealer() {
        return dealer;
    }
}
