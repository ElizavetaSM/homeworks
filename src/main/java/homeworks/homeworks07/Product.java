package homeworks.homeworks07;

import java.util.Objects;

public class Product { //характеристики продукта
    protected String name;
    protected Integer price;
//геттеры и сеттеры
    public Product() { //конструктор
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) { //условия для названия продукта
        boolean hasDigits = false;
        for (int i = 0; i < name.length() && !hasDigits; i++) { // не должно быть цифр в названии
            if (Character.isDigit(name.charAt(i))) {
                hasDigits = true;
            System.out.println("Недопустимое имя продукта");}}
        if (name.isEmpty()) { // название продукта не может быть пустым
            System.out.println("Недопустимое имя продукта: Название продукта не может быть пустой строкой");}
        else if (name.length()<3) { // название продукта не модет быть короче 3 символов
            System.out.println("Недопустимое имя продукта: Название продукта не может быть короче 3 символов");}
        else {
            this.name = name;  }

    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) { // условие для цены продукта
        if (price <= 0) {
            System.out.println("Недопустимая стоимость продукта: Стоимость продукта не может быть 0 или отрицательным числом");}
        else {
            this.price = price;}
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name) && Objects.equals(price, product.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }
}