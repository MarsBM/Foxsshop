package domain.order;

import domain.product.Product;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Mars on 29.09.2016.
 */
@Entity
public class OrderItem implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "order_")
    private Order order;

    @Column(name = "quantity_")
    private Integer quantity;

    @Column(name = "price_")
    private Double price;

    @Id
    @ManyToOne
    @JoinColumn(name = "product")
    private Product product;

    public OrderItem() {
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderItem orderItem = (OrderItem) o;

        if (quantity != null ? !quantity.equals(orderItem.quantity) : orderItem.quantity != null) return false;
        if (price != null ? !price.equals(orderItem.price) : orderItem.price != null) return false;
        return product != null ? product.equals(orderItem.product) : orderItem.product == null;

    }

    @Override
    public int hashCode() {
        int result = quantity != null ? quantity.hashCode() : 0;
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (product != null ? product.hashCode() : 0);
        return result;
    }
}
