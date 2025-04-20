package homeworks.homeworks07;

import java.time.LocalDate;
import java.util.Objects;

public class DiscountProduct extends Product { // характеристики продукта со скидкой при наследовании родительского класса
    private Integer discount;
    private LocalDate discountDate;
    private Boolean isDiscounted;

    public DiscountProduct() { //конструктор
        super();
        this.discount = discount;
        this.discountDate = LocalDate.of(2025,1,31); //устанолвена срок действия скидки
        this.isDiscounted = true;
    }

    public void addProduct (DiscountProduct discountProduct) { //метод для определения продукта со скидкой и без
        if (discount==0) {
            System.out.println(discountProduct.getName() + " обычный продукт");}
        else if (LocalDate.now().isBefore(discountDate)) {
            System.out.println ("Акционный продукт " + discountProduct.getName());;}
        else {
            System.out.println(discountProduct.getName() + " обычный продукт"); }

    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public LocalDate getDiscountDate() {
        return discountDate;
    }

    public void setDiscountDate(LocalDate discountDate) {
        this.discountDate = discountDate;
    }

    public Boolean getDiscounted() {
        return isDiscounted;
    }

    public void setDiscounted(Boolean discounted) {
        isDiscounted = discounted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        DiscountProduct that = (DiscountProduct) o;
        return Objects.equals(discount, that.discount) && Objects.equals(discountDate, that.discountDate) && Objects.equals(isDiscounted, that.isDiscounted);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), discount, discountDate, isDiscounted);
    }

    @Override
    public String toString() {
        return "DiscountProduct{" +
                "discount=" + discount +
                ", discountDate=" + discountDate +
                ", isDiscounted=" + isDiscounted +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
