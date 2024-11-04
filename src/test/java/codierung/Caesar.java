package codierung;

public class Caesar {

    public static String code(char rotationOffset, String klartext) {
        char[] ca = klartext.toCharArray();
        int os = (int)(Character.toLowerCase(rotationOffset))- (int) 'a';
        for (int i= 0; i<ca.length; i++){
            char c = ca[i];
            if (c>='a' && c<='z'){
                c = (char)(((int)c - (int)'a' + os)%26 + 'a');
            }
            else if (c>='A'&& c<='Z'){
                c = (char)(((int)c - (int)'A' + os)%26 + 'A');
            }
            ca[i] = c;
        }
        String chiffre = String.copyValueOf(ca);
        return chiffre;
    }

    public static String encode(char rotationOffset, String chiffre) {
        char codingOffset = 'a';
        int os = (int)(Character.toLowerCase(rotationOffset))- (int) 'a';
        os = 26 - os;
        codingOffset = (char) ((int)'a' + os);
        return code(codingOffset, chiffre);
    }

    public static void main(String[] args) {
        char key = 'h';
        String chiffre = code(key, "BlaBlablazBlabla");
        System.out.println(chiffre);
        String klartext = encode(key, chiffre);
        System.out.println(klartext);

        chiffre = code('m', "Walter");
        klartext = encode('m', chiffre);
        System.out.println(chiffre+" "+klartext);
    }

}
