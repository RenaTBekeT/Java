import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class CountLines {
    public static int countLines(String filename) {
        Path filepath = Paths.get("File");

        try {
            return (int )Files.lines(filepath).count();
        } catch (IOException e) {
            return 0;
        }

    }


    public static void main(String[] args) {
        String filename = "my-file.txt";
        int lineCount = countLines("File.txt");
        System.out.println("Number of line: " + lineCount);
    }
}
