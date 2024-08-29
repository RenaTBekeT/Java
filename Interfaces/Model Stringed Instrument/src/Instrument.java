public abstract class Instrument {
    protected String name;
    public abstract void play();

    public String getName() {
        return name;
    }

    public Instrument(String name) {
        this.name = name;
    }
}
