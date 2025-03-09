package homeworks.homeworks06;

import java.util.*;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Buyer> buyers = new ArrayList<>();
        List<Product> products = new ArrayList<>();

        while (true) {
            System.out.print("Введите имена покупателей и суммы денег");
            String inputBuyer = scanner.nextLine();
            if (inputBuyer.equals(".")) break;

            String[] buyersEntries = inputBuyer.split(";");
            for (String entry : buyersEntries) {
                String [] stringBuyers = entry.split("=");
            if (stringBuyers.length ==2) {
            String nameOfBuyer = stringBuyers[0].trim();
                if (!nameOfBuyer.isEmpty()) {
                    try {
                        int moneyOfBuyer = Integer.parseInt(stringBuyers[1].trim());
                        buyers.add(new Buyer(nameOfBuyer, moneyOfBuyer)); }
                catch (NumberFormatException e) {
                    System.out.println("Некорректная сумма для покупателя: " + nameOfBuyer);
                }}
        System.out.println(buyers);}}}


            while (true) {
                System.out.print("Введите названия продуктов и их цены");
                String inputProduct = scanner.nextLine();
                if (inputProduct.equals(".")) break; // Выход из цикла
                String [] productEntries = inputProduct.split(";");
                for (String entry : productEntries){
                   String[] stringProduct = entry.split("=");
                if (stringProduct.length == 2) {
                String nameOfProduct = stringProduct[0].trim();
                try {
                    int priceOfProduct = Integer.parseInt(stringProduct[1].trim());
                    products.add(new Product(nameOfProduct, priceOfProduct));
                }
                catch (NumberFormatException e) {
                    System.out.println("Некорректная сумма для покупателя: " + nameOfProduct);
                }}
                    System.out.println(products);

            }}

            while (true) {
                System.out.println("Введите имя покупателя и название продукта (или END для завершения)");
                String inputLine = scanner.nextLine();
                if (inputLine.equals("END"))
                    break; // Выход из цикла

                String[] buyerProductPairs = inputLine.split(",");
                for (String entry : buyerProductPairs) {
                    String part  = entry.trim();
                    String [] parts = part.split("-");
                if (parts.length >= 2) {
                String buyersName = parts[0].trim();
                String productName = parts[1].trim();

                Buyer buyer = Buyer.findBuyer(buyers, buyersName);
                Product product = Product.findProduct(products, productName);

                    if (buyer != null && product != null) {
                        buyer.addProductToBusket(product);

                }
            }

                for (Buyer buyer : buyers) {
                    if (buyer.hasProductsInBasket()) {
                        System.out.println(buyer.getName() + " - " + buyer.getProductsInBasket());
                    } else {
                        System.out.println(buyer.getName() + " - Ничего не куплено");
                    }


            }}}}}


