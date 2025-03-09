package homeworks.homeworks06;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


    public class Buyer { // характрестики покупателя
        private String name;
        private int money;
        private List <Product> basket;
        

        public Buyer(String name, int money) {
            if (name == null || name.isEmpty()) {
                throw new IllegalArgumentException("Имя не может быть пустым");
            }
            else this.name = name;
            if (money<0) {
                throw new IllegalArgumentException("Деньги не могут быть отрицательными");
            }
            else this.money = money;
            this.basket = new ArrayList<>();
        }


        public void addProductToBusket (Product product) { //метод для добавления продуктов в корзину
            if (this.money >= product.getPrice()) { // условие возможности покупки по цене
                this.basket.add(product);
                this.money -= product.getPrice();  // Вычитаем стоимость продукта
                System.out.println (getName() + " купил (а) " + product.getName());}
            else {
                System.out.println(getName() + " не может позволить себе купить " + product.getName());
                }

        }
        public boolean hasProductsInBasket() {
            return !basket.isEmpty();
        }

        public String getProductsInBasket() {
            List<String> productNames = new ArrayList<>();
            for (Product product : basket) {
                productNames.add(product.getName());
            }
            return String.join(", ", productNames);
        }
        public static Buyer findBuyer(List<Buyer> buyers, String name) {
            if (buyers == null || name == null) {
                System.out.println("Список покупателей или имя не может быть null.");
                return null;
            }
            for (Buyer buyer : buyers) {
                if (buyer != null && name.equals(buyer.getName())) {
                    return buyer;
                }
            }
            System.out.println("Покупатель не найден.");
            return null; // Если не найден
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
        public List<Product> getBasket() {
            return basket;
        }

        public void setBasket(List<Product> basket) {
            this.basket = basket;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            homeworks.homeworks06.Buyer buyer = (homeworks.homeworks06.Buyer) o;
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

