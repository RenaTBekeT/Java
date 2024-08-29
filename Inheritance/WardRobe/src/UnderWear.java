public class UnderWear extends Cloth {
    public UnderWear(String type, String color) {
        super(type, color);
        this.condition = 100;
    }

    @Override
    public boolean needsToBeWashed() {
        return daysworn >= 1;
    }
}





