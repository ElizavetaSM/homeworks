package homeworks.homeworks03;

public class App {
    public static void main(String[] args) {
        Television myTelevision = new Television(60, 80, "Black"); //использование конструктора 1
        Television myTelevision1 = new Television(); // использование конструктора со стандратными параметрами
        Television myTelevision2 = new Television(); // использование конструктора со стандратными параметрами
        myTelevision2.setColour("White"); // изменение цвета телевизора при испльзовании конструктора
        System.out.println(myTelevision);
        System.out.println(myTelevision1);
        System.out.println(myTelevision2);}}
