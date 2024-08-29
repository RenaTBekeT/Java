public class Tree extends Plant {
    double needswater;
    double absorbation;

    public double getNeedswatwr() {
        return needswater;
    }

    public double getAbsorbation() {
        return absorbation;
    }

    public Tree(String color) {
        super(color);
        this.needswater = 10;
        this.absorbation = 0.4;
    }
    @Override
    public void waterPlant(double amount) {
        if (currentamount < needswater) {
            amount = amount * absorbation;
            currentamount += amount;
        }
        System.out.println(currentamount);
    }
}

