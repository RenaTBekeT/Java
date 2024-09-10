import java.util.Random;

public class Pirate {
    public int intoxication;
    private Random random;
    public boolean isAlive;

    public Pirate() {
        this.intoxication = 0;
        this.random = new Random();
        this.isAlive = true;
    }

    public void drinkSomeRum() {
        intoxication += 1;
    }

    public void howsItGoingMate() {
        if (intoxication < 4) {
            System.out.println("Pour me anudder!");
        }
        else {
            System.out.println("Arghh, I'ma Pirate. How d'ya d'ink its goin?");
            intoxication = 0;
        }
    }

    public void die() {
        this.isAlive = false;
        System.out.println("On pirate died.");
    }

    public void brawl(Pirate enemyPirate) {
        if (this.isAlive && enemyPirate.isAlive) {
            int r1 = random.nextInt(3);
            if (r1 == 0) {
                this.die();
            }
            if (r1 == 1) {
                enemyPirate.die();
            }
            if (r1 == 2) {
                this.die();
                enemyPirate.die();
            }
        }
    }
}
