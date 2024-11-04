package at.ac.htlstp.et.aiit23k4b2.dateien;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FaustAnalyse1 {
    public static void main(String[] args) throws IOException {
        File file = new File("textdatei.txt"); // Ändern Sie den Dateinamen entsprechend
        List<String> data = Files.readAllLines(file.toPath());
        System.out.println(data.size() + " Zeilen gefunden");
        Pattern wordPattern = Pattern.compile("(^|[\\s,.;:?!)\\]]?)([a-zA-ZöüäÖÜÄß]+[a-zA-ZöüäÖÄÜß])($|[\\s,.;:?!(\\[])");
        int wordCount = 0;
        int letterACount = 0;

        for (String line : data) {
            Matcher matcher = wordPattern.matcher(line);
            while (matcher.find()) {
                wordCount++;
                String word = matcher.group(2);
                for (int i = 0; i < word.length(); i++) {
                    if (Character.toLowerCase(word.charAt(i)) == 'a') {
                        letterACount++;
                    }
                }
            }
        }

        System.out.println(wordCount + " Worte gefunden!");
        System.out.println("Die Anzahl der Buchstaben 'a' in der Datei ist: " + letterACount);
    }
}
