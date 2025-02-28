package homeworks.homework08;

import java.util.Objects;

public class Product {
    private String name;
    private int price;

    public Product(String name, int price) { //конструктор
        this.name = name;
        this.price = price;
        if (name.isEmpty()) {
            throw new IllegalArgumentException ("Название продукта не может быть пустой строкой");}
        if (this.price < 0) {
            throw new IllegalArgumentException ("Стоимость продукта не может быть отрицательным числом");}}


    public Product() {

    }
    // геттеры и сеттеры
    public String getName() {
        return name;
    }

    public void setName(String name) {
            this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
            this.price = price;
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

