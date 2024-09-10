import java.util.ArrayList;
import java.util.List;

public class Armada {
    public List<PirateShip> ships = new ArrayList<>();
    String name;

    public Armada(String name) {
        this.name = name;
    }

    public void fillArmada() {
        for (int i = 0; i < 10; i++) {
            PirateShip ship = new PirateShip();
            ship.fillShip();
            ships.add(ship);
        }
    }

    public int countAll() {
        int armadaAllPirates = 0;
        for (PirateShip ship : ships) {
            armadaAllPirates += ship.alivePirates();
        }
        return armadaAllPirates;
    }

    public void representationArmada() {
        System.out.println("Armada has " + ships.size() + " ships with " + countAll() + " " +  name);
    }

    public boolean war(Armada otherArmada) {
        int thisShipIndex = 0;
        int otherShipIndex = 0;

        while (thisShipIndex < this.ships.size() && otherShipIndex < otherArmada.ships.size()) {
            PirateShip thisShip = this.ships.get(thisShipIndex);
            PirateShip otherShip = otherArmada.ships.get(otherShipIndex);

            if (thisShip.battle(otherShip)) {
                otherShipIndex++; // this ship wins, other ship gets skipped
            } else {
                thisShipIndex++; // other ship wins, this ship gets skipped
            }
        }
        return thisShipIndex < this.ships.size(); // if there are still ships left in this armada, this armada wins
    }
}


