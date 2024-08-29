import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Farm {
    private List<Animal> listOfanimals;

    private int limit;

    public Farm(int limit) {
        this.listOfanimals = new ArrayList<>();
        this.limit = limit;
    }

    public void breed() {
        if (listOfanimals.size() < limit) {
            Animal newanimal = new Animal();
            listOfanimals.add(newanimal);
            System.out.println("new animal was born!");
        } else {
            System.out.println("no more place");
        }
    }

    public void sell() {
        if (!listOfanimals.isEmpty()) {
            Animal leastHungryAnimal = listOfanimals.stream()
                    .min(Comparator.comparingInt(Animal::getHunger))
                    .orElse(null);

            if (leastHungryAnimal != null) {
                System.out.println("Selling the least hungry animal: " + leastHungryAnimal.getName());
                listOfanimals.remove(leastHungryAnimal);
            }
        } else {
            System.out.println("No animals on the farm to sell!");
        }


        }
    }


