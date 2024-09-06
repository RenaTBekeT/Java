public class WarApp {
    public static void main(String[] args) {
        Armada brightheroes = new Armada();
        Armada sunwarriors = new Armada();

        brightheroes.fillarmada();
        sunwarriors.fillarmada();

        if (brightheroes.war(sunwarriors)) {
            System.out.println("brightheroes are winners");
        } else {
            System.out.println("sunwarriors are winnners");
        }

    }
}
