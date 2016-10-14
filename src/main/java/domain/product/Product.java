package domain.product;

import domain.category.Category;
import domain.customer.CartItem;
import domain.manufacturer.Manufacturer;
import domain.order.OrderItem;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Created by Mars on 12.08.2016.
 */
@Entity
@Table(name = "Product")
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ElementCollection
    @CollectionTable(
            name="product_descriptions",
            joinColumns=@JoinColumn(name="product")
    )
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<ProductDescription> descriptions = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "product_category",
            joinColumns = {@JoinColumn(name = "product")},
            inverseJoinColumns = {@JoinColumn(name = "category")})
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Category> categories = new ArrayList<>();

    @ElementCollection
    @CollectionTable(
            name="product_options",
            joinColumns=@JoinColumn(name="product")
    )
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<ProductOption> options = new ArrayList<>();

    @OneToMany(mappedBy = "product")
    @LazyCollection(LazyCollectionOption.FALSE)
    private Set<CartItem> cartItems;

    @OneToMany(mappedBy = "product")
    @LazyCollection(LazyCollectionOption.FALSE)
    private Set<OrderItem> orderItems;

    @ManyToOne
    @JoinColumn(name = "manufacturer")
    @LazyCollection(LazyCollectionOption.FALSE)
    private Manufacturer manufacturer;

    @Column(name = "create_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss.S")
    private Date createDate;

    @Column(name = "modify_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss.S")
    private Date modifyDate;

    @ElementCollection
    @CollectionTable(
            name="product_attributes",
            joinColumns=@JoinColumn(name="product")
    )
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<ProductAttribute> attributes = new ArrayList<>();

    @Column(name = "price")
    private Double price;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "min_quantity")
    private Integer minimumQuantity;

    @Column(name = "rating")
    private Double rating;

    @Column(name = "subtract_stock")
    private Boolean subtractStock;

    @Column(name = "enable")
    private Boolean enable;

    @Column(name = "enable_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private Date enableDate = new Date();

    /*

        ТЕГИ окремою таблицею


     .акції
     .постійні знижки

     картинки

     .відгуки

     .статус на складі



     теги(в описи)

     модель??
     .габарити
     .вага


    */

    public Product() {
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getMinimumQuantity() {
        return minimumQuantity;
    }

    public void setMinimumQuantity(Integer minimumQuantity) {
        this.minimumQuantity = minimumQuantity;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Boolean getSubtractStock() {
        return subtractStock;
    }

    public void setSubtractStock(Boolean subtractStock) {
        this.subtractStock = subtractStock;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    public Date getEnableDate() {
        return enableDate;
    }

    public void setEnableDate(Date enableDate) {
        this.enableDate = enableDate;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public List<ProductAttribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<ProductAttribute> attributes) {
        this.attributes = attributes;
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

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<ProductDescription> getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(List<ProductDescription> descriptions) {
        this.descriptions = descriptions;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public List<ProductOption> getOptions() {
        return options;
    }

    public void setOptions(List<ProductOption> options) {
        this.options = options;
    }

    public Set<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(Set<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public Set<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(Set<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (id != null ? !id.equals(product.id) : product.id != null) return false;
        if (descriptions != null ? !descriptions.equals(product.descriptions) : product.descriptions != null)
            return false;
        if (categories != null ? !categories.equals(product.categories) : product.categories != null) return false;
        if (options != null ? !options.equals(product.options) : product.options != null) return false;
        if (cartItems != null ? !cartItems.equals(product.cartItems) : product.cartItems != null) return false;
        return orderItems != null ? orderItems.equals(product.orderItems) : product.orderItems == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (descriptions != null ? descriptions.hashCode() : 0);
        result = 31 * result + (categories != null ? categories.hashCode() : 0);
        result = 31 * result + (options != null ? options.hashCode() : 0);
        result = 31 * result + (cartItems != null ? cartItems.hashCode() : 0);
        result = 31 * result + (orderItems != null ? orderItems.hashCode() : 0);
        return result;
    }
}