import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Logs {
    public static void main(String[] args) {
        // Write a method `getUniqueIpAddresses` which accepts a path to `log.txt`
        // as a parameter and returns an array of unique IP addresses.
        // Write a method `getRequestRatio` which accepts a path to `log.txt`
        // as a parameter and returns the ratio of GET to POST requests.
        // If the specified file cannot be found the methods should return an empty
        // array and 0.0 respectively (and raise no errors).
        // Change the path of the log.txt source file to the path
        // where you saved it on your computer.
        // You can find the source file in a link next to this exercise.
        System.out.println(String.join(System.lineSeparator(), getUniqueIpAddresses("Log_file")));
        System.out.println(getRequestRatio("Log_file"));
    }

    public static List<String> getUniqueIpAddresses(String filename) {
        Path filepath = Paths.get(filename);
        HashSet<String> uniqueAdresses = new HashSet<>();
        try {
            List<String> lines = Files.readAllLines(filepath);
            for (int line = 0; line < lines.size(); line++) {
                String wholeLine = lines.get(line);
                uniqueAdresses.add(wholeLine.split("   ")[1]);
            }
            Path filePath = Paths.get("getUniqueAdresses_result.txt");
            Files.write(filePath, uniqueAdresses);
        } catch (IOException e) {

        }
        return new ArrayList<>(uniqueAdresses);
    }

    public static Double getRequestRatio(String filename) {
        Path filepath = Paths.get(filename);
        try {
            List<String> lines = Files.readAllLines(filepath);
            double countGet = 0;
            int countPost = 0;
            for (int line = 0; line < lines.size(); line++) {
                String wholeLine = lines.get(line);
                if (wholeLine.split("   ")[2].startsWith("G")) {
                    countGet++;
                } else {
                    countPost++;
                }
            }
            System.out.println(countGet);
            System.out.println(countPost);
            return countPost / countGet;
        } catch (IOException e) {
            return 0d;
        }
    }
}