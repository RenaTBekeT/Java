import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SharpieSet {
    private List<Sharpie> listOfSharpies;

    public SharpieSet() {
        listOfSharpies = new ArrayList<>();
    }

    public void add(Sharpie sharpie) {
        listOfSharpies.add(sharpie);
    }

    public int countUsable() {
        int usableCount = 0;

        for (Sharpie sharpie : listOfSharpies) {
            if (sharpie.getInkAmount() > 0) {
                usableCount++;
            }
        }
        return usableCount;
    }
        public void removeTrash () {
        Iterator <Sharpie> iterator = listOfSharpies.iterator();

           while (iterator.hasNext()) {
            Sharpie sharpie = iterator.next();
                if (sharpie.getInkAmount() <= 0) {
                    iterator.remove();
                }
            }

        }
}


