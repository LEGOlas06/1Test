package codierung;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class FaustCaesar {

    public static final String FAUST1 = "data/faust1.txt";
    public static final String CHIFFRE = "data/chiffre.txt";

    public static void main(String[] args) throws IOException {
        List<String> data = Files.readAllLines(new File(FAUST1).toPath());
        List<String> out = new ArrayList<>();
        for (String line : data)
            out.add(Caesar.code('g', line));
        Files.write(new File(CHIFFRE).toPath(), out);
    }

}
