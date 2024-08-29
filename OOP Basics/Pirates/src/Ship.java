import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ship {
    private List<Pirate> pirates;
    private Pirate captain;
    private Random random;


    public Ship() {
        this.pirates = new ArrayList<>();
        this.random = new Random();
    }

    public void fillship() {
        int r = random.nextInt(1, 114);
        for (int i = 0; i < r; i++) {
            pirates.add(new Pirate());
        }
        captain = new Pirate();
    }

    public int numofrums() {
        pirates.size();
        int numofrums = 0;
        for (Pirate pirate : pirates) {
            numofrums += pirate.getNumofrums();
        }
        numofrums += captain.getNumofrums();
        return numofrums;
    }


    public int numofalife() {
        int alifepirate = 0;
        for (Pirate pirate : pirates) {
            if (pirate.isAlife()) {
                alifepirate += 1;

            }
        }
        return alifepirate;
    }
    public void getinfo() {
        System.out.println("All pirates have drink " + numofrums() + " rums and there is " + numofalife() + " pirates");
    }
    public void killpirates() {
        for (int i = 0; i < pirates.size(); i++) {
            int r = random.nextInt(0, 2);
            if (r == 0) {
                pirates.get(i).die();
            }
        }
    }
    public boolean battle(Ship othership) {
         boolean result = (this.numofalife() - this.captain.getNumofrums() > othership.numofalife() - othership.captain.getNumofrums());
         if (result == true) {
             othership.killpirates();
             this.party();
         } else {
             this.killpirates();
             othership.party();
         }
         return result;
    }
    public void party() {
        for (Pirate pirate : pirates) {
            int s = random.nextInt(0, 5);
            pirate.drinkSomeRum(s);
        }
    }
}
