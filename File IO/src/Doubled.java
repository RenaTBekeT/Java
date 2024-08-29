import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Doubled {

    public static void main(String[] args) {
        // Create a method called `decryptDoubled` that takes a filename string
        // as a parameter and decrypts the file's content.
        // Decryption is the process reversing an encryption, i.e. the process
        // which converts encrypted data into its original form.
        // If the file can't be opened it should print this message: "File not found"
        // The (decrypted) result should be saved in the "output.txt" file (don't change the path).
        // Change the path of the duplicated-chars.txt source file to the path
        // where you saved it on your computer.
        // You can find the source file in a link next to this exercise.
        decryptDoubled("Doubled.file");
    }

    public static void decryptDoubled(String filename) {
        Path filepath = Paths.get(filename);
        try {
            List<String> lines = Files.readAllLines(filepath);
            List<String> decryptedLines = new ArrayList<>();
            for (int line = 0; line < lines.size(); line++) {
                String wholeLine = lines.get(line);
                String correctline = "";
                for (int word = 0; word < wholeLine.length(); word++) {
                    char letter = wholeLine.charAt(word);
                    if (word % 2 == 0) {
                        correctline += letter;
                    }

                }
                decryptedLines.add(correctline);
            }
            Path filePath1 = Paths.get("Doubled_result.txt");
            Files.write(filePath1, decryptedLines);
        } catch (IOException e) {
            System.out.println("Uh-oh, could not read the file!");
        }
    }
}
