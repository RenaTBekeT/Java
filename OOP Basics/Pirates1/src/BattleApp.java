public class BattleApp {
    public static void main(String[] args) {
        Ship blackSwan = new Ship();
        Ship darkwave = new Ship();

        darkwave.fillship();
        blackSwan.fillship();

        blackSwan.getinfo();
        darkwave.getinfo();

        if (blackSwan.battle(darkwave)) {
            System.out.println("Blackswan is winner");
        } else {
            System.out.println("darkwave is winnner");
        }
        blackSwan.getinfo();
        darkwave.getinfo();


    }
}