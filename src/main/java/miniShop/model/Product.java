package miniShop.model;
import lombok.Data;

@Data
public final class Product {

    private final String name;

    private final double price;

    private final double discountPrice;

    private final double amount;

    private final double discountAmount;

}
