import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class EncodedLines {
    public static void main(String[] args) {
        // Create a method called `decryptEncoded` that takes a filename string
        // as a parameter and decrypts the file's content.
        // Decryption is the process reversing an encryption, i.e. the process
        // which converts encrypted data into its original form.
        // If the file can't be opened it should print this message: "File not found"
        // The (decrypted) result should be saved in the "output.txt" file (don't change the path).
        // Change the path of the encoded-lines.txt source file to the path
        // where you saved it on your computer.
        // You can find the source file in a link next to this exercise.
        // You have to figure out the encryption logic by yourself.
        EncodedLines("EncodedLines_file1");
    }

    public static void EncodedLines(String filename) {
        Path filepath = Paths.get(filename);
        try {
            List<String> lines = Files.readAllLines(filepath);
            List<String> decryptedLines = new ArrayList<>();
            for (int line = 0; line < lines.size(); line++) {
                String wholeLine = lines.get(line);
                StringBuilder correctline = new StringBuilder();
                for (int word = 0; word < wholeLine.length(); word++) {
                    char letter = wholeLine.charAt(word);
                    if (letter == 'a') {
                        correctline.append('z');
                    } else if (letter == ' ') {
                        correctline.append(letter);
                    } else if (letter == '.') {
                        correctline.append(letter);
                    } else {
                        char letter1 = (char) (letter - 1);
                        correctline.append(letter1);
                    }
                }
                decryptedLines.add(correctline.toString());
            }
            Path filePath1 = Paths.get("Encoded_lines_result.txt");
            Files.write(filePath1, decryptedLines);
        } catch (IOException e) {
            System.out.println("Uh-oh, could not read the file!");
        }
    }
}