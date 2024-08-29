public class Counter {
    private int counter;
    private int initialvalue;

    public Counter() {
        this.counter = 0;
        this.initialvalue = 0;
    }
    public Counter(int counter) {
        this.counter = counter;
        this.initialvalue = counter;
    }
    public void add(int number) {
        counter += number;
    }

    public void add() {
        counter++;
    }

    public int get() {
        return counter;
    }

    public int reset() {
        return counter = 0;
    }
    public int resettoinit() {
        return counter = initialvalue;
    }
}
