import java.util.Random;

public class Pirate {
    private int intoxication;
    private boolean alife;
    private Random random;
    private int numofrums;

    public Pirate() {
        this.intoxication = 0;
        this.alife = true;
        this.random = new Random();
        this.numofrums = 0;
    }

    public void drinkSomeRum() {
        intoxication += 1;
        numofrums += 1;
    }
    public void drinkSomeRum(int numberofrums) {
        intoxication += numberofrums;
        numofrums += numberofrums;
    }

    public int getIntoxication() {
        return intoxication;
    }
    public boolean isAlife() {
        return alife;
    }

    public Random getRandom() {
        return random;
    }

    public int getNumofrums() {
        return numofrums;
    }

    public void howsItGoingMate() {
        if (intoxication < 4) {
            System.out.println("Pour me anudder!");
        } else {
            System.out.println("Arghh, I'ma Pirate. How d'ya d'ink its goin?");
            intoxication = 0;
        }

    }

    public void die() {
        this.alife = false;
        System.out.println("he is death");

    }

    public void brawl(Pirate otherPirate) {
        if (!this.alife || !otherPirate.alife) {
            return;
        }
        int r = random.nextInt(0, 3);
        if (r == 0) {
            this.die();
        }
        if (r == 1) {
            otherPirate.die();
        }
        if (r == 2) {
            this.die();
            otherPirate.die();
        }
    }
}
