public class BassGuitar extends StringedInstrument{
    public BassGuitar(int numberOfStrings) {
        super("BassGuitar", numberOfStrings);
    }
    public BassGuitar() {
        super("BassGuitar", 4);
    }

    @Override
    public void play() {
        System.out.println(name + " a " + numberOfStrings + "-stringed instrument that goes "  +sound());
    }

    @Override
    public String sound() {
        return "Duum-duum-duum";
    }
}