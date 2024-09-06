
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class WriteSingleLine {
    public static void main(String[] args) {
        List<String> content = new ArrayList();
        content.add("First line of my file");
        Path filePath = Paths.get("File");

        try { // Required by Files.write(filePath, content)
            // Creates a new file if not exists and overwrites it's content
            // The elements of the content lists will become the lines of the file
            Files.write(filePath, content);
        } catch (IOException e) {
            System.out.println("Uh-oh, could not write the file!");
        }
    }
}

