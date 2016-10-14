package domain.manufacturer;

import domain.product.Product;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import javax.validation.Valid;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 * Created by Mars on 10.10.2016.
 */
@Entity
public class Manufacturer implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "image")
    private String image;

    @ElementCollection
    @CollectionTable(
            name="Manufacturer_descriptions",
            joinColumns=@JoinColumn(name="manufacturer")
    )
    @Valid
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<ManufacturerDescription> descriptions;

    @OneToMany(mappedBy = "manufacturer")
    private Set<Product> products;

    public Manufacturer() {
    }

    public Manufacturer(String image, List<ManufacturerDescription> descriptions) {
        this.image = image;
        this.descriptions = descriptions;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<ManufacturerDescription> getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(List<ManufacturerDescription> descriptions) {
        this.descriptions = descriptions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Manufacturer that = (Manufacturer) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (image != null ? !image.equals(that.image) : that.image != null) return false;
        return descriptions != null ? descriptions.equals(that.descriptions) : that.descriptions == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (image != null ? image.hashCode() : 0);
        result = 31 * result + (descriptions != null ? descriptions.hashCode() : 0);
        return result;
    }
}
