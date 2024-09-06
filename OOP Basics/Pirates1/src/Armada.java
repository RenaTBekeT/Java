import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Armada {
    private Random random;

    private List<Ship> ships;

    public Armada() {
        this.ships = new ArrayList<>();
        this.random = new Random();
    }

    public List<Ship> getShips() {
        return ships;
    }

    public void fillarmada() {
        int r = random.nextInt(1, 20);
        for (int i = 0; i < r; i++) {
            Ship ship = new Ship();
            ship.fillship();
            ships.add(ship);
        }
    }
    public boolean war(Armada otherarmada) {
        List<Ship>otherships = otherarmada.getShips();
        int indexships = 0;
        int indexotherships = 0;

        while (true) {
            if (indexships == ships.size()) {
                return false;
            }
            if (indexotherships == otherships.size()) {
                return true;
            }
            boolean resultofbattle = ships.get(indexships).battle(otherships.get(indexotherships));
        if (resultofbattle == true) {
            indexotherships++;
        } else {
            indexships++;
        }
        }

    }
}
