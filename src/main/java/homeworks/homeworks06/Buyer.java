package homeworks.homeworks06;

import java.util.Objects;

public class Buyer { // характрестики покупателя
    private String name;
    private int money;
    private Product [] basket = new Product[10];

    private int index = 0;

    public Buyer() {
        this.name = name;
        this.money = money;
        this.basket = basket;
    }

    public void addProductToBusket (Product product) { //метод для добавления продуктов в корзину
        if (this.money > product.getPrice()) { // условие возможности покупки по цене
            this.basket [index] = product;
            index++;
            System.out.println (getName() + " купил (а) " + product.getName());}
        else {
            System.out.println(getName() + " не может позволить себе купить " + product.getName());
            do {
                System.out.println("Ничего не куплено");}
            while (basket.length == 0);}

    }
//геттеры и сеттеры
    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.isEmpty()) {
            System.out.println("Имя не может быть пустым");}
        else {
            this.name = name;}
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        if (money < 0) {
            System.out.println("Деньги не могут быть отрицательными");}
        else {
            this.money = money;}
    }

    public Product[] getBasket() {
        return basket;
    }

    public void setBasket(Product[] basket) {
        this.basket = basket;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Buyer buyer = (Buyer) o;
        return money == buyer.money && Objects.equals(name, buyer.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, money);
    }

    @Override
    public String toString() {
        return "Buyer{" +
                "name='" + name + '\'' +
                ", money=" + money +
                '}';
    }


}
