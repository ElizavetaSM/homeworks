package homeworks.homework08;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Buyer {
    private String name;
    private int money;
    private List <homeworks.homework08.Product> basket;


    public Buyer(String name, int money) {
        this.name = name;
        this.money = money;
        this.basket = new ArrayList<>();
        if (name.isEmpty()) {
            System.out.println("Имя не может быть пустым");}
        if (this.money < 0) {
            System.out.println("Деньги не могут быть отрицательными");}
            }

    public Buyer() {

    }

    public void addProductToBusket (Product product) {//метод для добавления продуктов в корзину
        StringBuilder message = new StringBuilder();
        if (product.getPrice() <= money) { // условие возможности покупки по цене
            basket.add(product);
            money -= product.getPrice();
            writeToFile(String.valueOf(message.append(name).append(" купил (а) ").append(product.getName())));
            }
        else {
            writeToFile(String.valueOf(message.append(name).append(" не может позволить себе купить ").append(product.getName())));
            }
        writeToFile(getBusketSummary());
    }
    private void writeToFile(String string) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter (new FileWriter("src/main/java/homeworks/homework08/output.txt", true));
            bufferedWriter.write(string);
            bufferedWriter.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getBusketSummary() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(name).append(": ");
        if (basket.isEmpty()) {
            stringBuilder.append(" ничего не куплено ");
        }
        for (Product product : basket) {
            stringBuilder.append(product.getName());
        }

        return stringBuilder.toString().trim();}



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public List<homeworks.homework08.Product> getBasket() {
        return basket;
    }

    public void setBasket(List<homeworks.homework08.Product> basket) {
        this.basket = basket;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Buyer buyer = (Buyer) o;
        return money == buyer.money && Objects.equals(name, buyer.name) && Objects.equals(basket, buyer.basket);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, money, basket);
    }

    @Override
    public String toString() {
        return "Buyer{" +
                "name='" + name + '\'' +
                ", money=" + money +
                ", basket=" + basket +
                '}';
    }








}
