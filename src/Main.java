import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[][] key = createKey();
        for (int i = 0; i < 77; i++) {
            System.out.println(key[i][1]);
        }

        label:
        while (true){
            String s = scanAction();
            switch (s) {
                case "f":
                    break label;
                case "c": {
//                Кодируем
                    String text = scanText();
                    StringBuilder code = new StringBuilder();
                    System.out.println("Шифруемый текст: " + text);
                    for (int i = 0; i < text.length(); i++) {
                        code.append(coding(text.substring(i, i + 1), key));
                    }
                    System.out.println(code);
                    break;
                }
                case "d": {
//                Расшифровка
                    String text = scanText();
                    StringBuilder code = new StringBuilder();
                    System.out.println("Дешифруемый текст: " + text);
                    for (int i = 0; i < text.length(); i += 2) {
                        code.append(decoding(text.substring(i, i + 2), key));
                    }
                    System.out.println(code);
                    break;
                }
            }
        }
    }

    private static String coding(String s, String[][] key){
        for (String[] strings : key) {
            if (s.equalsIgnoreCase(strings[0])) {
                return strings[1];
            }
        }
        return "00";
    }

    private static String[][] createKey(){
        String[][] key = new String[77][2];
        key[0][0] = ")";
        key[1][0] = ".";
        key[2][0] = ",";
        key[3][0] = "?";
        key[4][0] = " ";
        int j = 5;
        for (int i = 0; i < 26; i++) {
            key[j][0] = "" + (char)(i+97);
            j++;
        }
        for (int i = 0; i < 32; i++) {
            key[j][0] = "" + (char)(i+1072);
            j++;
        }
        for (int i = 0; i < 10; i++) {
            key[j][0] = "" + (char)(i+48);
            j++;
        }
        key[74][0] = "ё";
        key[75][0] = "!";
        key[73][0] = "-";
        key[76][0] = "(";
        Random rand = new Random(51);
        for (int i = 0; i < key.length; i++) {
            key[i][1] = key[rand.nextInt(26) + 4][0] + key[rand.nextInt(26) + 4][0];
        }
        return  key;
    }


    private static String decoding(String s, String[][] key){
        for (String[] strings : key) {
            if (s.equalsIgnoreCase(strings[1])) {
                return strings[0];
            }
        }
        return "0";
    }

    private static String scanAction(){
        System.out.println("Введите команду: 'c' - закодировать, 'd' - декодировать, 'f' - закончить работу программмы");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private static String scanText(){
        System.out.println("Введите текст");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}


