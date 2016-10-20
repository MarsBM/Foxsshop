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

/**
 * Created by Mars on 12.08.2016.
 */
@Entity
@Table(name = "Product")
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_")
    private Long id;

    @ElementCollection
    @CollectionTable(
            name="product_descriptions",
            joinColumns=@JoinColumn(name="product_")
    )
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<ProductDescription> descriptions = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "product_category",
            joinColumns = {@JoinColumn(name = "product_")},
            inverseJoinColumns = {@JoinColumn(name = "category_")})
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Category> categories = new ArrayList<>();

    @ElementCollection
    @CollectionTable(
            name="product_options",
            joinColumns=@JoinColumn(name="product_")
    )
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<ProductOption> options = new ArrayList<>();

    @OneToMany(mappedBy = "product")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<CartItem> cartItems;

    @OneToMany(mappedBy = "product")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<OrderItem> orderItems;

    @ManyToOne
    @JoinColumn(name = "manufacturer_")
    @LazyCollection(LazyCollectionOption.FALSE)
    private Manufacturer manufacturer;

    @Column(name = "create_date_")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss.S")
    private Date createDate;

    @Column(name = "modify_date_")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss.S")
    private Date modifyDate;

    @ElementCollection
    @CollectionTable(
            name="product_attributes",
            joinColumns=@JoinColumn(name="product_")
    )
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<ProductAttribute> attributes = new ArrayList<>();

    @Column(name = "price_")
    private Double price;

    @Column(name = "quantity_")
    private Integer quantity;

    @Column(name = "min_quantity_")
    private Integer minimumQuantity;

    @Column(name = "rating_")
    private Double rating;

    @Column(name = "quantity_of_votes_")
    private Integer quantityOfVotes;

    @Column(name = "subtract_stock_")
    private Boolean subtractStock;

    @Column(name = "enable_")
    private Boolean enable;

    @Column(name = "enable_date_")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private Date enableDate = new Date();

    @Column(name = "length_")
    private Double length;

    @Column(name = "width_")
    private Double width;

    @Column(name = "height_")
    private Double height;

    @Column(name = "weight_")
    private Double weight;

    @Column(name = "views_")
    private Integer views;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Review> reviews = new ArrayList<>();

    /*
        ТЕГИ окремою таблицею
     .акції
     .постійні знижки
     картинки
     .статус на складі
     теги(в описи)
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

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public Integer getQuantityOfVotes() {
        return quantityOfVotes;
    }

    public void setQuantityOfVotes(Integer quantityOfVotes) {
        this.quantityOfVotes = quantityOfVotes;
    }

    public Double getLength() {
        return length;
    }

    public void setLength(Double length) {
        this.length = length;
    }

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
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
        if (orderItems != null ? !orderItems.equals(product.orderItems) : product.orderItems != null) return false;
        if (manufacturer != null ? !manufacturer.equals(product.manufacturer) : product.manufacturer != null)
            return false;
        if (createDate != null ? !createDate.equals(product.createDate) : product.createDate != null) return false;
        if (modifyDate != null ? !modifyDate.equals(product.modifyDate) : product.modifyDate != null) return false;
        if (attributes != null ? !attributes.equals(product.attributes) : product.attributes != null) return false;
        if (price != null ? !price.equals(product.price) : product.price != null) return false;
        if (quantity != null ? !quantity.equals(product.quantity) : product.quantity != null) return false;
        if (minimumQuantity != null ? !minimumQuantity.equals(product.minimumQuantity) : product.minimumQuantity != null)
            return false;
        if (rating != null ? !rating.equals(product.rating) : product.rating != null) return false;
        if (quantityOfVotes != null ? !quantityOfVotes.equals(product.quantityOfVotes) : product.quantityOfVotes != null)
            return false;
        if (subtractStock != null ? !subtractStock.equals(product.subtractStock) : product.subtractStock != null)
            return false;
        if (enable != null ? !enable.equals(product.enable) : product.enable != null) return false;
        if (enableDate != null ? !enableDate.equals(product.enableDate) : product.enableDate != null) return false;
        if (length != null ? !length.equals(product.length) : product.length != null) return false;
        if (width != null ? !width.equals(product.width) : product.width != null) return false;
        if (height != null ? !height.equals(product.height) : product.height != null) return false;
        if (weight != null ? !weight.equals(product.weight) : product.weight != null) return false;
        if (views != null ? !views.equals(product.views) : product.views != null) return false;
        return reviews != null ? reviews.equals(product.reviews) : product.reviews == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (descriptions != null ? descriptions.hashCode() : 0);
        result = 31 * result + (categories != null ? categories.hashCode() : 0);
        result = 31 * result + (options != null ? options.hashCode() : 0);
        result = 31 * result + (cartItems != null ? cartItems.hashCode() : 0);
        result = 31 * result + (orderItems != null ? orderItems.hashCode() : 0);
        result = 31 * result + (manufacturer != null ? manufacturer.hashCode() : 0);
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        result = 31 * result + (modifyDate != null ? modifyDate.hashCode() : 0);
        result = 31 * result + (attributes != null ? attributes.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (quantity != null ? quantity.hashCode() : 0);
        result = 31 * result + (minimumQuantity != null ? minimumQuantity.hashCode() : 0);
        result = 31 * result + (rating != null ? rating.hashCode() : 0);
        result = 31 * result + (quantityOfVotes != null ? quantityOfVotes.hashCode() : 0);
        result = 31 * result + (subtractStock != null ? subtractStock.hashCode() : 0);
        result = 31 * result + (enable != null ? enable.hashCode() : 0);
        result = 31 * result + (enableDate != null ? enableDate.hashCode() : 0);
        result = 31 * result + (length != null ? length.hashCode() : 0);
        result = 31 * result + (width != null ? width.hashCode() : 0);
        result = 31 * result + (height != null ? height.hashCode() : 0);
        result = 31 * result + (weight != null ? weight.hashCode() : 0);
        result = 31 * result + (views != null ? views.hashCode() : 0);
        result = 31 * result + (reviews != null ? reviews.hashCode() : 0);
        return result;
    }
}