package th.ac.utc.Product.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private Long id;
    private String name;
    private double price;
    private int stock;
    public double getTotalValue() { return price * stock; }
}