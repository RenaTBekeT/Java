import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ReversedLines {
    public static void main(String[] args) {
        // Create a method called `decryptReversed` that takes a filename string
        // as a parameter and decrypts the file's content.
        // Decryption is the process reversing an encryption, i.e. the process
        // which converts encrypted data into its original form.
        // If the file can't be opened it should print this message: "File not found"
        // The (decrypted) result should be saved in the "output.txt" file (don't change the path).
        // Change the path of the reversed-lines.txt source file to the path
        // where you saved it on your computer.
        // You can find the source file in a link next to this exercise.
        decryptReversed("reversedLines_file");
    }

    public static void decryptReversed(String filename) {
        Path filepath = Paths.get(filename);
        try {
            List<String> lines = Files.readAllLines(filepath);
            List<String> correctlines = new ArrayList<>();
            for (int i = 0; i < lines.size(); i++) {
                String Line = lines.get(i);
                String correctline = "";
                for (int j= 0; j < Line.length(); j++) {
                    correctline = Line.charAt(j) + correctline;
                }
                correctlines.add(correctline);
            }
                Path filePath1 = Paths.get("ReversedLines_result.txt");
                Files.write(filePath1, correctlines);
        } catch (IOException e) {
            System.out.println("cant read the file");
        }
    }
}

