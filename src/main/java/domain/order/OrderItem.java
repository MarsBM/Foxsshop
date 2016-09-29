package domain.order;

import domain.product.Product;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

/**
 * Created by Mars on 29.09.2016.
 */
@Entity
public class OrderItem implements Serializable {

    private Integer quantity;
    private Double price;

    @Id
    @ManyToOne
    @JoinColumn(name = "order_")
    private Order order;

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

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
