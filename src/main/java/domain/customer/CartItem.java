package domain.customer;

import domain.product.Product;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Mars on 29.09.2016.
 */
@Entity
public class CartItem implements Serializable{

    @Id
    @ManyToOne
    @JoinColumn(name = "customer")
    private Customer customer;

    @Column(name = "quantity_")
    private Integer quantity;

    @Id
    @ManyToOne
    @JoinColumn(name = "product")
    private Product product;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CartItem cartItem = (CartItem) o;

        if (customer != null ? !customer.equals(cartItem.customer) : cartItem.customer != null) return false;
        if (quantity != null ? !quantity.equals(cartItem.quantity) : cartItem.quantity != null) return false;
        return product != null ? product.equals(cartItem.product) : cartItem.product == null;

    }

    @Override
    public int hashCode() {
        int result = customer != null ? customer.hashCode() : 0;
        result = 31 * result + (quantity != null ? quantity.hashCode() : 0);
        result = 31 * result + (product != null ? product.hashCode() : 0);
        return result;
    }
}
