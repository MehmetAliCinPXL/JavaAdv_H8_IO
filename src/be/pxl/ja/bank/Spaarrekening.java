package be.pxl.ja.bank;

import java.io.*;

public class Spaarrekening implements Serializable {
    private int saldo;
    private String naam;
    private String nummer;

    public Spaarrekening(int s, String naam, String num){
        this.naam = naam;
        this.nummer = num;
        this.saldo = s;
    }

    @Override
    public String toString() {
        return "Spaarrekening" + "\n"+
                "saldo=" + saldo + "\n"+
                ", naam='" + naam + + '\'' + "\n" +
                ", nummer='" + nummer + '\'';
    }

    public static void main(String[] args) {
        Spaarrekening spaarrekening = new Spaarrekening(100, "mehmet cin", "BE97 1630 3834");

        try (FileOutputStream file = new FileOutputStream("resources/bank.ser");  ObjectOutputStream out = new ObjectOutputStream(file)){
            out.writeObject(spaarrekening);
        }catch (IOException ex) {
            System.out.println(ex.getMessage ());
        }
        //in try () zodat de file access autocloseable is.
        // Deserialisatie
        try {
            FileInputStream file = new FileInputStream("resources/bank.ser");
            ObjectInputStream input = new ObjectInputStream(file);
            Spaarrekening spaarrekening1 = (Spaarrekening)input.readObject();
            System.out.println(spaarrekening1.toString());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

