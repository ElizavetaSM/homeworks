package homeworks.homeworks06;

import java.util.Scanner;

public class App {
    public static void main (String [] args) {
        Buyer buyer = new Buyer();
        Product product = new Product();
        System.out.println("Введите имя покупателя и сумму");
        Scanner scanner = new Scanner(System.in);
        buyer.setName(scanner.nextLine());
        buyer.setMoney(scanner.nextInt());
        System.out.println("Введите продукт и цену");
        Scanner scanner1 = new Scanner(System.in);
        product.setName(scanner1.nextLine());
        product.setPrice(scanner1.nextInt());
        buyer.addProductToBusket(product);

        boolean check = true;
        while (check) {
            String input = scanner.next();
            if (input.equals("END")) {
                check = false;
            }

        }
    }
}