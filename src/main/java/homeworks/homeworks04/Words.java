package homeworks.homeworks04;

import java.util.Arrays;
import static java.util.Arrays.sort;

public class Words {
    public static void main(String[] args) {
        String str = "hide and seek";
        String [] words = str.split(" ");
        sort(words);
        System.out.println(Arrays.toString(words).toLowerCase());
    }
}
