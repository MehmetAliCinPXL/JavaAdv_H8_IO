package be.pxl.ja.phonebook;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class PhoneApp {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        Path phonebookPath = Paths.get("resources/phonedirectory.txt");
        // TODO create a collection
        Map<String ,String > phoneBook = new HashMap <>();
        // TODO load collection from file
        try {
            BufferedReader reader = Files.newBufferedReader(phonebookPath, Charset.defaultCharset());
            String line;
            while ((line = reader.readLine()) != null){
                String[] contact = line.split(";");
                String[] nummers = Arrays.stream(contact).skip(1).toArray(String[]::new);
                phoneBook.put(contact[0], Arrays.stream(nummers).map(n -> n).collect(Collectors.joining(";")));
                //phoneBook.put(contact[0], nummers);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        phoneBook.forEach((k,v) -> System.out.println("naam: "+k+" nummer(s):"+v));

        boolean running = true;
        while (running) {
            System.out.println("Geef een naam: ");
            String naam = input.nextLine();
            if (phoneBook.containsKey(naam)){
                System.out.println("Geef een telefoonnummer: ");
                String telnr = input.nextLine();
                if (phoneBook.get(naam).contains(telnr)){
                    throw new RuntimeException("dit nummer is al toegevoegd");
                }else {
                    phoneBook.put(naam, phoneBook.get(naam) + ";" + telnr);
                }
            }
            System.out.println("Wilt u nog namen toevoegen? (j/n)");
            running = input.nextLine().equals("j");
        }

        // TODO save contacts to file
        try (BufferedWriter writer =  Files.newBufferedWriter(phonebookPath)) {
            for (Map.Entry<String, String> entry : phoneBook.entrySet()) {
                StringBuilder s = new StringBuilder();
                s.append(entry.getKey() + ";" + entry.getValue());
                writer.write(String.valueOf(s) +"\n");
            }
            } catch (IOException e) {
            e.printStackTrace();
        }
        //wrm input close, het is toch autocloseable?
        input.close();
    }
}
