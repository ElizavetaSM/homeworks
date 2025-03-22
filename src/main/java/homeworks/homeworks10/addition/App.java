package homeworks.homeworks10.addition;

public class App {
    public static void main(String[] args) {
        Pair<Integer, String> pair = Pair.of(1, "hello");
        Integer F = pair.getFirst(); // 1
        String  S = pair.getSecond(); // "hello"

        Pair<Integer, String> pair2 = Pair.of(1, "hello");
        boolean mustBeTrue = pair.equals(pair2); // true!
        boolean mustAlsoBeTrue = pair.hashCode() == pair2.hashCode(); // true!
        System.out.println(mustBeTrue);
        System.out.println(mustAlsoBeTrue);
    }
}

