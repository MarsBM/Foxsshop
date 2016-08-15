package domain;

import javax.persistence.ManyToMany;
import java.util.Date;
import java.util.Set;

/**
 * Created by Mars on 12.08.2016.
 */
public class Product {

    private Integer id;
    private String model;
    private Integer quantity;
    private StockStatus stockStatus;

    private String image;

    private Manufacturer manufacturer;
    private Boolean shipping;
    private Double price;
    private Date dateAvailable;
    private Double weight;
    private Double height;
    private Double width;
    private Double length;
    private Boolean subtract;
    private Integer minimum;
    private String status;
    private Boolean isEnabled;
    private Integer viewed;
    private Date createDate;
    private Date modifyDate;

    private Review review;
    private Category category;

    private Option option;
    private Attribute attribute;

    private Description description;

    @ManyToMany(mappedBy = "cart")
    private Set<Customer> customersCart;

    @ManyToMany(mappedBy = "wishlist")
    private Set<Customer> customersWishlist;
}
