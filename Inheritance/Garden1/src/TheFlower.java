public class TheFlower extends Plant {
    double needswater;
    double absorbation;

    public TheFlower(String color) {
        super(color);
        this.needswater = 5;
        this.absorbation = 0.75;
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
