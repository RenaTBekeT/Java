public class WarApp {
    public static void main(String[] args) {
        Armada Terminators = new Armada("Bejčkové");
        Terminators.fillArmada();
        Terminators.representationArmada();

        Armada Humans = new Armada("Beketové");
        Humans.fillArmada();
        Humans.representationArmada();

        if (Terminators.war(Humans)) {
            System.out.println("Jirka Bejček bejček šel radší na metro, utekl");
        }
        else {
            System.out.println("Renda beket se posral");
        }
    }
}

