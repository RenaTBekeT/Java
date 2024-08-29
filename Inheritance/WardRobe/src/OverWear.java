public class OverWear extends Cloth {
    public OverWear(String type, String color) {
        super(type, color);
        this.condition = 50;
    }

    @Override
    public boolean needsToBeWashed() {
        return  daysworn >= 5;
    }


    @Override
    public boolean needsToBeRepaired() {
        return  condition > 1 && condition < 5;

    }
}

