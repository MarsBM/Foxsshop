package domain.order;

import domain.customer.Customer;
import domain.user.User;
import org.hibernate.annotations.IndexColumn;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import javax.validation.Valid;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Created by Mars on 29.09.2016.
 */
@Entity
@Table(name = "orders_")
public class Order implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_")
    private Integer id;

    @OneToMany(mappedBy = "order")
    @OrderColumn(name = "order_state_index")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<OrderStateItem> orderStateItems;

    private Date created;
    private Date shipped;
    private Date delivered;
    private Double totalPrice;

    @ManyToOne
    @JoinColumn(name = "customer")
    private Customer customer;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<OrderItem> orderItems;

    @ManyToOne
    @JoinColumn(name = "manager")
    private User manager;

    private String comment;

    public Order() {
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getShipped() {
        return shipped;
    }

    public void setShipped(Date shipped) {
        this.shipped = shipped;
    }

    public Date getDelivered() {
        return delivered;
    }

    public void setDelivered(Date delivered) {
        this.delivered = delivered;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public User getManager() {
        return manager;
    }

    public void setManager(User manager) {
        this.manager = manager;
    }

}
