package domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

/**
 * Created by Mars on 12.08.2016.
 */
@Entity
@Table(name = "Customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

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

    @OneToMany(mappedBy = "customer")
    private List<Telephone> telephones;

    @Column(name = "password")
    @NotNull
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

    public Customer() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Telephone> getTelephones() {
        return telephones;
    }

    public void setTelephones(List<Telephone> telephones) {
        this.telephones = telephones;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
