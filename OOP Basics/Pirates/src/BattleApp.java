public class BattleApp {
    public static void main(String[] args) {
        PirateShip iceQueen = new PirateShip();
        iceQueen.fillShip();

        PirateShip blackSwan = new PirateShip();
        blackSwan.fillShip();

        iceQueen.representation();
        blackSwan.representation();

        if (iceQueen.battle(blackSwan)) {
            System.out.println("iceQueen is winner");
        }
        else {
            System.out.println("blackSwan is winner");
        }
    }
}
