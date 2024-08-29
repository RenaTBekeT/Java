public abstract class Animal {
    protected String name;
    protected int age;

    protected String gender;
    protected int weight;
    protected int power;

    public Animal(String name, int age, String gender, int weight, int power) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.weight = weight;
        this.power = power;
    }

    public String getName() {
        return name;
    }

    public abstract String breed();
}
