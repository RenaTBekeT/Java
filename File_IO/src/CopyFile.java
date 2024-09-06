import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class CopyFile {
    public static void main(String[] args) {
        Path filePath = Paths.get("File");
        try {
            List<String> lines = Files.readAllLines(filePath);
            Path filePath1 = Paths.get("File1");
            Files.write(filePath1, lines);

            // Prints the first line of the file
        } catch (IOException e) {
            System.out.println("Uh-oh, could not read the file!");
        }
    }
}

    // Write a `copy` function that copies the contents of a file into another file.
    // The function should take two filenames (strings) as parameters:
    //  - path and name of the source file
    //  - path and name of the target file
    // It should return a boolean that shows whether the copy was successful or not.
