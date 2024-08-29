public class Main {
    public static void main(String[] args) {
        Garden garden = new Garden();
        TheFlower yellowflower = new TheFlower("yellow");
        TheFlower blueFlower = new TheFlower("blue");
        Tree purpletree = new Tree("purple");
        Tree orangetree = new Tree("orange");

        garden.addflower(yellowflower);
        garden.addflower(blueFlower);
        garden.addtree(purpletree);
        garden.addtree(orangetree);
        garden.printGardenStatus();

        garden.watterAll(40);
        garden.printGardenStatus();

        garden.watterAll(40);
        garden.printGardenStatus();


    }
}