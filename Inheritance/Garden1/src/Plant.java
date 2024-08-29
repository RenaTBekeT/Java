public class Plant {
    String color;
    double currentamount;
    public Plant(String color) {
        this.color = color;
        this.currentamount = 0;
    }
    public String getColor() {
        return color;
    }

    public double getCurrentamount() {
        return currentamount;
    }
    public void waterPlant ( double amount) {
        amount += currentamount;
    }
}
