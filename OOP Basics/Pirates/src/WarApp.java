public class WarApp {
    public static void main(String[] args) {
        Armada Terminators = new Armada("Terminators");
        Terminators.fillArmada();
        Terminators.representationArmada();

        Armada Humans = new Armada("Humans");
        Humans.fillArmada();
        Humans.representationArmada();

        if (Terminators.war(Humans)) {
            System.out.println("John Connor was terminated");
        }
        else {
            System.out.println("The world is saved");
        }
    }
}

