package domain;

import domain.ready.Telephone;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Created by Mars on 12.08.2016.
 */
@Entity
@Table(name = "Customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "firstName", length = 25)
    @NotNull
    @Size(min = 1, max = 25)
    private String firstName;

    @Column(name = "lastName", length = 25)
    @NotNull
    @Size(min = 1, max = 25)
    private String lastName;

    @Column(name = "email", unique = true)
    @Pattern(regexp = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,}$")
    private String email;

    @ManyToMany
    @JoinTable(name = "customer_telephone",
            joinColumns = {@JoinColumn(name = "telephones")},
            inverseJoinColumns = {@JoinColumn(name = "customers")})
    private Set<Telephone> telephones;

    @Column(name = "password")
    @NotNull
    private String password;

    @ManyToMany
    @JoinTable(name="cart",
            joinColumns={@JoinColumn(name="customer")},
            inverseJoinColumns={@JoinColumn(name="product")})
    private Set<Product> cart;

    @JoinTable(name="wishlist",
            joinColumns={@JoinColumn(name="customer")},
            inverseJoinColumns={@JoinColumn(name="product")})
    private Set<Product> wishlist;

    @Column(name = "newsletter")
    @NotNull
    private Boolean newsletter;

    @OneToMany(mappedBy = "customer")
    private Set<Address> addresses;


    private CustomerGroup customerGroup;
    private String ip;
    private Boolean isEnabled;
    private Date createDate;
    private Date modifyDate;

}
