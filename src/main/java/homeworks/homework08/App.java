package homeworks.homework08;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class App {
    public static void main(String[] args) {
        Map<String, Buyer> buyers = new HashMap<>();
        Map<String, Product> products = new HashMap<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("src/main/java/homeworks/homework08/input.txt"))) {
            // Чтение покупателей из файла
            String line = bufferedReader.readLine();
            String[] buyerData = line.split(";");

            for (String data : buyerData) {
                String[] parts = data.split("=");
                String buyerName = parts[0].trim();
                int money = Integer.parseInt(parts[1].trim());
                buyers.put(buyerName, new Buyer(buyerName, money));

            }
            line = bufferedReader.readLine();
            String[] productData = line.split(";");

            for (String data : productData) {
                String[] parts = data.split("=");
                String productName = parts[0].trim();
                int price = Integer.parseInt(parts[1].trim());
                Product product = new Product(productName, price);
                products.put(productName, product);
            }
            line = bufferedReader.readLine();
            while (line != null && !line.equals("END")) {
                String[] parts = line.split("-");
                String buyerName = parts[0].trim();
                String productName = parts[1].trim();

                Buyer buyer = buyers.get(buyerName);
                Product product = products.get(productName);

                if (buyer != null && product != null) {
                    buyer.addProductToBusket(product);
                }
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}

