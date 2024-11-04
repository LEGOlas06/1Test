package codierung;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.List;

public class AnalyseHack {

    public static final String REFFERENZTEXT = "data/faust2.txt";

    public static final String CHIFFRETEXT = "data/chiffre.txt";


    public static char sucheHaufigstenBuchstaben(List<String> ref) {
        HashMap<Character, Integer> ar = new HashMap<>();
        int max = 0;
        char maxC = ' ';
        for (String line : ref) {
            for (char c : line.toCharArray()) {
                if (Character.isLetter(c)) {
                    c = Character.toLowerCase(c);
                    if (ar.containsKey(c)) {
                        ar.put(c, ar.get(c) + 1);
                    } else {
                        ar.put(c, 1);
                    }
                    if (ar.get(c) > max) {
                        max = ar.get(c);
                        maxC = c;
                    }
                }
            }
        }
        return maxC;
    }

    public static void main(String[] args) throws IOException {
        List<String> ref = Files.readAllLines(new File(REFFERENZTEXT).toPath());
        List<String> chiffre = Files.readAllLines(new File(CHIFFRETEXT).toPath());
        HashMap<Character, Integer> ar = new HashMap<>();

        char c = sucheHaufigstenBuchstaben(ref);
        char cc = sucheHaufigstenBuchstaben(chiffre);

        int osr = (int) c - (int) 'a';
        int osc = (int) cc - (int) 'a';
        int osKey = (osc - osr + 26) % 26;
        char key = (char)((int) 'a' + osKey);

        System.out.println("KEY:" + key);

        System.out.println("REF:" + c);
        System.out.println("CHIFFRE:" + cc);
    }
}
