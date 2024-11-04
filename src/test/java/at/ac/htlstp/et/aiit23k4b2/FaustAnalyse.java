package at.ac.htlstp.et.aiit23k4b2;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FaustAnalyse {
    public static void main(String[] args) throws IOException {
        File file = new File("data/faust.txt"); // Ändern Sie den Dateinamen entsprechend
        List<String> data = Files.readAllLines(file.toPath());
        System.out.println(data.size() + " Zeilen gefunden");
        Pattern wordPattern = Pattern.compile("(^|[\\s,.;:?!)\\]]?)([a-zA-ZöüäÖÜÄß]+[a-zA-ZöüäÖÄÜß])($|[\\s,.;:?!(\\[])");
        int wordCount = 0;
        int wordWithAOrACount = 0;

        for (String line : data) {
            Matcher matcher = wordPattern.matcher(line);
            while (matcher.find()) {
                wordCount++;
                String word = matcher.group(2);
                if (word.toLowerCase().contains("a")||word.toUpperCase().contains("A")) { // Überprüfen, ob das Wort 'a' oder 'A' enthält
                    wordWithAOrACount++;
                }
            }
        }

        System.out.println(wordCount + " Worte gefunden!");
        System.out.println(wordWithAOrACount + " Worte gefunden, die den Buchstaben 'A' oder 'a' enthalten.");
    }
}
