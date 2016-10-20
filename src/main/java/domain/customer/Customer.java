package domain.customer;

import domain.order.Order;
import domain.product.Product;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Created by Mars on 12.08.2016.
 */
@Entity
@Table(name = "customers")
public class Customer implements Serializable{

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_")
    private Long id;

    @Id
    @Column(name = "email_", unique = true)
    private String email;

    @Column(name = "first_name_", length = 25)
    private String firstName;

    @Column(name = "last_name_", length = 25)
    private String lastName;

    @ElementCollection
    @CollectionTable(
            name="customers_telephones",
            joinColumns=@JoinColumn(name="customer_")
    )
    @Column(name="phone_number_")
    private List<String> telephones;

    @Column(name = "password_")
    private String password;

    @Column(name = "newsletter_")
    private Boolean newsletter;

    @ManyToOne
    @JoinColumn(name = "customer_group_")
    private CustomerGroup customerGroup;

    @Column(name = "ip_")
    private String ip;

    @Column(name = "status_")
    private Boolean isEnabled;

    @Column(name = "create_date_")
    private Date createDate;

    @Column(name = "modify_date_")
    private Date modifyDate;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<CartItem> cartItems;

    @OneToMany(mappedBy = "customer")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Order> orders;

    @ElementCollection
    @CollectionTable(
            name="customer_wishlist",
            joinColumns=@JoinColumn(name="customer_")
    )
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Product> wishlist;

    public Customer() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<String> getTelephones() {
        return telephones;
    }

    public void setTelephones(List<String> telephones) {
        this.telephones = telephones;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getNewsletter() {
        return newsletter;
    }

    public void setNewsletter(Boolean newsletter) {
        this.newsletter = newsletter;
    }

    public CustomerGroup getCustomerGroup() {
        return customerGroup;
    }

    public void setCustomerGroup(CustomerGroup customerGroup) {
        this.customerGroup = customerGroup;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Boolean getEnabled() {
        return isEnabled;
    }

    public void setEnabled(Boolean enabled) {
        isEnabled = enabled;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public List<Product> getWishlist() {
        return wishlist;
    }

    public void setWishlist(List<Product> wishlist) {
        this.wishlist = wishlist;
    }
}
