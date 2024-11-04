package at.ac.htlstp.et.aiit23k4b2.dateien;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Locale;

public class DateiTest {
    public static final String FILE_TEXT = "data/test1.txt";
    private static final String FILE_OUT = "data/out.txt";

    public static void main(String[]args) throws IOException {
        File file = new File(FILE_TEXT);
        File out = new File(FILE_OUT);
        if (file.exists()){
            System.out.println("Inhalt der Datei " +file.getAbsolutePath()+ ":");
            try {
                List<String> data = Files.readAllLines(file.toPath());
                for (int zn=0;zn<data.size();zn++){
                    data.set(zn,data.get(zn).toUpperCase());
                }
                Files.write(out.toPath(),data);
            } catch (IOException e){
                System.out.println("Datei " +file.getAbsolutePath()+ " kann nicht gelesen werden");
            }

        }else System.out.println("Datei " +file.getAbsolutePath()+ " exestiert nicht");
    }
}
