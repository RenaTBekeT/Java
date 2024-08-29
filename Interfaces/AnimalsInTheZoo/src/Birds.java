public class Birds extends Animal{
    public Birds(String name, String gender, int weight, int power) {
        super(name, 0, gender, weight, power);
    }

    @Override
    public String breed() {
        return name + "is breading by lying eggs";
     }
    public void hasBigTeeth() {
        System.out.println(name + " Has huuge teeth");
    }

    @Override
    public void move() {
        System.out.println("is flying");
    }
}

