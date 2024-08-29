public class Animal {
    private int hunger;
    private int thirst;

    private int name;

    public Animal() {
        this.hunger = 50;
        this.thirst = 50;
        this.name = name;
    }

    public int getHunger() {
        return hunger;
    }
    public int getName() {
        return name;
    }

    public int getThirst() {
        return thirst;
    }
    public void eat() {
        hunger--;
    }
    public void drink() {
        thirst--;
    }
    public void play() {
        hunger++;
        thirst++;
    }

}


