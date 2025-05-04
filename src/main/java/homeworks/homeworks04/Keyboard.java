package homeworks.homeworks04;

public class Keyboard {
    public static void main(String[] args) {
        String alhabet = "qwertyuiopasdfghjklzxcvbnm";
        char [] chars = alhabet.toCharArray();
        Scanner scanner = new Scanner(System.in);
        String letter = scanner.next();
        int index = alhabet.indexOf(letter);
        boolean containChar;
        if (alhabet.contains(String.copyValueOf(letter.toCharArray()))) {
            containChar = true;
            if (index == 0) {
                System.out.println(alhabet.charAt(25));}
            else {
                System.out.println(alhabet.charAt(index-1));}
    }
}
}

