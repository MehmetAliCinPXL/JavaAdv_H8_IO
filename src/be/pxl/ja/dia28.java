package be.pxl.ja;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class dia28 {
    public static void main(String[] args) {
        try {
            List<String> words = Files.readAllLines(Path.of("resources/code.code"));
            words.stream().forEach(s -> Arrays.stream(s.split(" ")).filter(s1 -> s1.equals(s1.toUpperCase())).forEach(System.out::println));
            //hoe kan ik van deze stream een string van maken?
        }catch (IOException e){
            e.printStackTrace();
        }


    }
}
