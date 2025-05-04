package homeworks.homeworks10;


import java.util.Arrays;


public class App {
    public static void main(String[] args) {

        ByCondition condition = number -> number % 2 == 0;
        int [] intArray = Sequence.filter(new int [] {1, 2, 3}, condition);
        System.out.println(Arrays.toString(intArray));


        int [] intArray1 = new int[] {1, 2, 3};
        ByCondition condition1 = number -> Arrays.stream(intArray1).sum() % 2 == 0;
        Sequence.filter(intArray1, condition1);
        System.out.println (Arrays.stream(intArray1).sum());





    }

}

