package domain.customer;

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
public class CartItem implements Serializable{

    private Integer quantity;

    @Id
    @ManyToOne
    @JoinColumn(name = "product")
    private Product product;

    @Id
    @ManyToOne
    @JoinColumn(name = "customer")
    private Customer customer;

    public CartItem() {
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
