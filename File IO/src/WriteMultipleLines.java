import javax.imageio.IIOException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class WriteMultipleLines {

    public static void writelines(String path, String word, int number) {
        List<String> content = new ArrayList();
        for (int i = 0; i < number; i++) {
            content.add(word);
        }
        Path filepath = Paths.get("File");

        try {
            Files.write(filepath, content);
        } catch (IIOException e) {
            System.out.println("sorry no file");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    public static void main(String[] args) {
        writelines("File", "apple", 5);
    }
}

