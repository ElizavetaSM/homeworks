package homeworks.homeworks07;

import java.util.Scanner;

public class App {
public static void main (String [] args) {
    DiscountProduct discountProduct = new DiscountProduct();
    System.out.println("Введите название продукту, его цену и скидку");
    Scanner scanner = new Scanner(System.in);
    discountProduct.setName(scanner.nextLine());
    discountProduct.setPrice(scanner.nextInt());
    discountProduct.setDiscount(scanner.nextInt());
    discountProduct.addProduct(discountProduct);




}
}
