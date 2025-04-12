package homeworks.homework14;

import java.util.List;
import java.util.Objects;

public class Product {
    private String name;
    private int price;

    public Product(String name, int price) { //конструктор
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Имя не может быть пустым");
        }
        else this.name = name;
        if (price<0) {
            throw new IllegalArgumentException("Стоимость не может быть отрицательными числом");
        }
        this.price = price;
    }


    public static Product findProduct(List<Product> products, String name) {
        for (Product product : products) {
            if (product == null){
                continue;
            }
            String productName = product.getName();
            if (productName != null && productName.equals(name)) {
                return product;
            }
        }
        return null; // Если не найден
    }

    // геттеры и сеттеры
    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.isEmpty()) {
            System.out.println("Название продукта не может быть пустой строкой");}
        else {
            this.name = name;}
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        if (price < 0) {
            System.out.println("Стоимость продукта не может быть отрицательным числом");}
        else {
            this.price = price;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return price == product.price && Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}

