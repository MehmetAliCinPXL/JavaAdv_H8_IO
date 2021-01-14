package be.pxl.ja;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class dia18 {
    public static void main(String[] args) {
        Path path = Path.of("resources/bijlage1.txt");
        Path output = Path.of("resources/output.txt");
        if (Files.exists(output)){
            try {
                Files.delete(output);
                System.out.println("file deleted");
            }catch (IOException e){
                e.printStackTrace();
            }
        }

        try(BufferedWriter writer = Files.newBufferedWriter(output)){
             List<String> words = Files.readAllLines(path);
             words = words.stream().distinct().sorted().collect(Collectors.toList());
            for (String s: words) {
                writer.write(s + "\n");
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
