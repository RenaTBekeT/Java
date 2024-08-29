public class Violin extends StringedInstrument{
    public Violin(int numberOfStrings) {
        super("Violin", numberOfStrings);
    }
    public Violin() {
        super("Violin", 4);
    }

    @Override
    public void play() {
        System.out.println(name + " a " + numberOfStrings + "-stringed instrument that goes "  +sound());
    }

    @Override
    public String sound() {
        return "Sreech";
    }
}