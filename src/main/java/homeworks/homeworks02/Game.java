package homeworks.homeworks02;
public class Game {
    public static void main(String[] args) {
        int V = (int) (Math.random()*3);
        int P = (int) (Math.random()*3);
        if (V==0){
            if (P==0) {
                System.out.println("Ничья");
            } else if (P==1) {
                System.out.println("Вася");
            } else if (P==2) {
                System.out.println("Петя");
            }
        } else if (V==1) {
            if (P == 0) {
                System.out.println("Петя");
            } else if (P == 1) {
                System.out.println("Ничья");
            } else if (P == 2) {
                System.out.println("Вася");
            }
        }
        else if (V==2) {
            if (P==0) {
                System.out.println("Вася");
            }
            else if (P==1) {
                System.out.println("Петя");
            }
            else if (P==2) {
                System.out.println("Ничья"); }
        }
    }
}

