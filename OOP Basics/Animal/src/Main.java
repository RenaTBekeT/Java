public class Main {
    public static void main(String[] args) {
        Animal animal = new Animal();
        System.out.println("hunger before" + animal.getHunger());
        System.out.println("thirst before" + animal.getHunger());

        animal.eat();
        animal.drink();
        animal.play();

        System.out.println("After Eating, Drinking, and Playing:");
        System.out.println("Hunger: " + animal.getHunger());
        System.out.println("Thirst: " + animal.getThirst());

        Farm farm = new Farm(5);

        farm.breed();
        farm.sell();
        animal.play();
        farm.sell();
        farm.breed();
        farm.breed();
        farm.breed();
        farm.breed();
        farm.breed();
        farm.breed();







    }
}