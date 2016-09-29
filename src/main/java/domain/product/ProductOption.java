package domain.product;

import javax.persistence.Embeddable;

/**
 * Created by Mars on 29.09.2016.
 */
@Embeddable
public class ProductOption {

    private String name;
    private Double price;
    private Integer quantity;

    public ProductOption() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
