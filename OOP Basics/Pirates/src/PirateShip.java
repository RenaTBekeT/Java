import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PirateShip {
    public List<Pirate> pirates = new ArrayList<>();
    private Pirate captain;
    private Random random;

    public PirateShip() {
        this.random = new Random();
        this.pirates = new ArrayList<>();
    }

    public void fillShip() {
        int r1 = random.nextInt(114);
        for (int i = 0; i < r1; i++) {
            pirates.add(new Pirate());
        }
        captain = new Pirate();
    }

    public int alivePirates() {
        int alivePirates = 0;
        for (Pirate pirate : pirates) {
            if (pirate.isAlive) {
                alivePirates += 1;

            }
        }
        return alivePirates;
    }

    public void representation() {
        System.out.println("captain had " + captain.intoxication + " rums and his state is " + captain.isAlive);
        System.out.println("On the ship are " + alivePirates() + " crazy pirates ");
    }

    public void killPirates() {
        for (int i = 0; i < pirates.size(); i++) {
            int r2 = random.nextInt(2);
            if (r2 == 0) {
                pirates.get(i).die();
            }
        }
    }

    public boolean battle(PirateShip enemyShip) {
        if ((this.alivePirates() - this.captain.intoxication) > (enemyShip.alivePirates() - enemyShip.captain.intoxication)) {
            enemyShip.killPirates();
            return true;
        }
        if ((this.alivePirates() - this.captain.intoxication) < (enemyShip.alivePirates() - enemyShip.captain.intoxication)) {
            this.killPirates();
            return false;
        } else {
            return true;
        }
    }
}
