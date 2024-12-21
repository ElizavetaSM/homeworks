package homeworks.homeworks04;

public class Keyboard {
    public static void main(String[] args) {
        // String alhabet = "qwertyuiopasdfghjklzxcvbnm";
        StringBuilder alhabet = new StringBuilder("qwertyuiopasdfghjklzxcvbnm");
        alhabet.replace(0, 27, "mqwertyuiopasdfghjklzxcvbn");
        System.out.println(alhabet);
    }
}

