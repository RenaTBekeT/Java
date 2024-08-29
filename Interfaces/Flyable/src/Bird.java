public class Bird extends Animal implements Flyable{
    public Bird(String name, String gender, int weight, int power) {
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
    public void land() {

    }

    @Override
    public void fly() {

    }

    @Override
    public void takeOff() {

    }
}