package domain;

import java.util.Date;
import java.util.List;

/**
 * Created by Mars on 12.08.2016.
 */
public class Customer {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private List<String> telephone;
    private String password;
    private String cart;
    private String wishlist;
    private Boolean newsletter;
    private String address;
    private CustomerGroup customerGroup;
    private String ip;
    private Boolean isEnabled;
    private Date createDate;
    private Date modifyDate;
}
