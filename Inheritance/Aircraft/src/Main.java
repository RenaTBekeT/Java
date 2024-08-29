public class Main {
    public static void main(String[] args) {
        Carrier ONE = new Carrier();
        Aircrafts hero = new F16();
        Aircrafts alpha = new F16();
        Aircrafts dog = new F16();
        Aircrafts wolf = new F35();
        Aircrafts warrior = new F35();

        Carrier Two = new Carrier();
        Aircrafts zero = new F16();
        Aircrafts dlpha = new F16();
        Aircrafts hog = new F16();
        Aircrafts golf = new F35();
        Aircrafts parrior = new F16();

        ONE.add(hero);
        ONE.add(alpha);
        ONE.add(dog);
        ONE.add(warrior);
        ONE.add(wolf);

        Two.add(zero);
        Two.add(dlpha);
        Two.add(hog);
        Two.add(parrior);
        Two.add(golf);

        ONE.getstatusall();
        ONE.fill();
        ONE.getstatusall();

        ONE.fight(Two);
        Two.getstatusall();


    }
}