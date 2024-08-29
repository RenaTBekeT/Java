public class ElectricGuitar extends StringedInstrument{
    public ElectricGuitar(int numberOfStrings) {
        super("electricGuitard", numberOfStrings);
    }
    public ElectricGuitar() {
        super("electricGuitar", 6);
    }

    @Override
    public void play() {
        System.out.println(name + " a " + numberOfStrings + "-stringed instrument that goes "  +sound());
    }

    @Override
    public String sound() {
    return "Twang";
    }
}
