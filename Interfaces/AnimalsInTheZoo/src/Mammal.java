public class Mammal extends Animal{
    public Mammal(String name, String gender, int weight, int power) {
        super(name, 0, gender, weight, power);
    }

    @Override
    public String breed() {
        return  name + " is pushing miniature versions out";
    }
    public void drinkmilk() {
        System.out.println(name + " is drinking mothers Milk");
    }

    @Override
    public void move() {
        System.out.println("is running");
    }
}
