import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Year;
import java.util.*;

public class Births {
    public static void main(String[] args) {
        // Create a function `getMostFrequentYear` which takes the name of a CSV file as a parameter,
        // - every row is in the following format: <person name>;<birthdate in YYYY-MM-DD format>;<city name>
        // and returns the year (as a String) when the most births happened.
        // If there were multiple years with the same number of births then return any of them.
        // If the given file doesn't exist, the function should return "File not found"

        // Change the path of the /births.csv source file to the path where you saved it on your computer.
        // You can find the source file in a link next to this exercis

        System.out.println(getMostFrequentYear("Births_file")); // should print "2006" or "2016"


        // getMostFrequentYear("src/main/resources/static/not-existing-file.csv")); // should print "File not found"
    }

    public static List<String> getMostFrequentYear(String filename) {
        Path filepath = Paths.get(filename);
        ArrayList<String> Lines = new ArrayList<>();
        HashMap<String, Integer> frequence = new HashMap<>();
        ArrayList<String> mostFrequentyear = new ArrayList<>();

        try {
            List<String> lines = Files.readAllLines(filepath);
            for (int line = 0; line < lines.size(); line++) {
                String wholeLine = lines.get(line);
                Lines.add(wholeLine.split(";")[1]);
            }
            for (String birth : Lines) {
                mostFrequentyear.add(birth.split("-")[0]);
            }
            for (String year : mostFrequentyear) {
                Integer count = frequence.get(year);
                if (count == null) {
                    count = 0;
                }

                frequence.put(year, count + 1);
            }
            Set<Map.Entry<String, Integer>> entrySet = frequence.entrySet();
            ArrayList<Map.Entry<String, Integer>> orderedFrequence = new ArrayList<>(entrySet);
            orderedFrequence.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
            System.out.println(orderedFrequence);
            System.out.println(Collections.max(frequence.entrySet(), HashMap.Entry.comparingByValue()).getKey());
            List<String> finalFreqence = new ArrayList<>();
            for (int i = 0; i < orderedFrequence.size(); i++) {
                if (orderedFrequence.get(i).getValue().equals(orderedFrequence.get(0).getValue())) {
                    finalFreqence.add(orderedFrequence.get(i).getKey());
                } else {
                    break;
                }
            }
            Path filePath = Paths.get("Births_result.txt");
            Files.write(filePath, mostFrequentyear);
            return finalFreqence;
        } catch ( IOException e) {
            System.out.println("File not found!");
        }
        return null;
    }

}


