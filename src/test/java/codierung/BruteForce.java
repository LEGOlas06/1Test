package codierung;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BruteForce {

    public static void main(String[] args) throws IOException {
        List<String> data = Files.readAllLines(new File("./data/chiffre.txt").toPath());
        for (char c = 'a'; c <= 'z'; c++) {
            List<String> encodedData = new ArrayList<>();
            //encode all lines with the current key
            for (String line : data) {
                encodedData.add(Caesar.encode(c, line));
            }
            //Analyse the result and look for keywords "und"
            int ct = 0;
            Matcher m;
            Pattern p = Pattern.compile("(^|[\\s,.;:?\\)\\]])?([uU]nd)($|[\\s,.;:?\\(\\[])");
            for (String line : encodedData) {
                m = p.matcher(line);
                while (m.find()) ct++;
            }
            if (ct > 0) {
                System.out.println("Der Key ist: " + c);
            }
            System.out.println("Key: "+c+" matches"+ct);
        }
    }
}
