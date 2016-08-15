package domain.ready;

import domain.Customer;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

/**
 * Created by Mars on 12.08.2016.
 */
@Entity
@Table(name = "Telephone")
public class Telephone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "number", length = 25)
    @NotNull
    @Size(min = 5, max = 25)
    private String number;

    @ManyToMany(mappedBy = "telephones")
    private Set<Customer> customers;

    public Telephone() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Set<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Set<Customer> customers) {
        this.customers = customers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Telephone telephone = (Telephone) o;

        return number.equals(telephone.number);

    }

    @Override
    public int hashCode() {
        return number.hashCode();
    }
}
