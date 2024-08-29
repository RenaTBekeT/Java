import java.util.ArrayList;
import java.util.List;

public class Garden {
    private List<TheFlower> flowers;
    private List<Tree> trees;

    public Garden() {
        flowers = new ArrayList<>();
        trees = new ArrayList<>();
    }

    public void addflower(TheFlower flower) {
        flowers.add(flower);
    }

    public void addtree(Tree tree) {
        trees.add(tree);
    }

    public void watterAll(double amount) {
        System.out.println("added");
        int numofplants = trees.size() + flowers.size();
        double amountperplant = amount / numofplants;

        for (TheFlower flower : flowers) {
            flower.waterPlant(amountperplant);
        }


        for (Tree tree : trees) {
            tree.waterPlant(amountperplant);

        }
    }
        public void printGardenStatus() {
            System.out.println("status now");
            for (TheFlower flower : flowers) {
                System.out.print(flower.getColor() + " flower:" );
                if (flower.getCurrentamount() < flower.needswater) {
                    System.out.println(" needs water, amount: ");
                    System.out.println(flower.currentamount);;
                } else {
                    System.out.println(" doesent need water");
                    System.out.println(flower.currentamount);;
                }
            }
            for (Tree tree : trees) {
                System.out.print(tree.getColor() + " tree: ");
                if (tree.getCurrentamount() < tree.needswater) {
                    System.out.println(" needs water");
                    System.out.println(tree.getCurrentamount());;
                } else {
                    System.out.println(" doesent need water");
                    System.out.println(tree.getCurrentamount());
                }
            }
            System.out.println();
        }
    }



