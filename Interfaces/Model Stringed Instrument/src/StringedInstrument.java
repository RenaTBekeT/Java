public abstract class StringedInstrument extends Instrument{
   protected int numberOfStrings;
    public StringedInstrument(String name,int numberOfStrings) {
        super(name);
        this.numberOfStrings = numberOfStrings;
    }
    public abstract String sound();
}
