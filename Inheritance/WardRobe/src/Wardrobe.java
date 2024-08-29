import java.util.ArrayList;
import java.util.List;

public class Wardrobe {
    private List<Cloth> clothes;

    public Wardrobe() {
        clothes = new ArrayList<>();
    }
    public void addcloth(Cloth cloth) {
        clothes.add(cloth);
    }
    public void washAllClothes() {
        for (Cloth cloth : clothes) {
            if (cloth.needsToBeWashed()) {
                cloth.wash();
            }
        }
    }

    public void printInfo() {
        for (Cloth cloth : clothes) {
            System.out.println(cloth.getinfo());
        }
    }

    public void repairAllClothes() {
        for (Cloth cloth : clothes) {
            if (cloth.needsToBeRepaired()) {
                cloth.repair();
            }
        }
    }

    public void purge() {
        for (Cloth cloth : clothes) {
            if (cloth.condition <= 0) {
                clothes.remove(cloth);
            }
        }
    }
}

