package domain.product;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Mars on 12.10.2016.
 */
@Entity
@Table(name = "attribute")
public class Attribute implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ElementCollection
    @CollectionTable(
            name="attribute_descriptions",
            joinColumns=@JoinColumn(name="product_attribute")
    )
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<AttributeDescription> descriptions;

    @Embedded
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<ProductAttribute> productAttributes;

    public Attribute() {
    }

    public Attribute(List<AttributeDescription> descriptions, List<ProductAttribute> productAttributes) {
        this.descriptions = descriptions;
        this.productAttributes = productAttributes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<AttributeDescription> getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(List<AttributeDescription> descriptions) {
        this.descriptions = descriptions;
    }

    public List<ProductAttribute> getProductAttributes() {
        return productAttributes;
    }

    public void setProductAttributes(List<ProductAttribute> productAttributes) {
        this.productAttributes = productAttributes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Attribute attribute = (Attribute) o;

        if (id != null ? !id.equals(attribute.id) : attribute.id != null) return false;
        if (descriptions != null ? !descriptions.equals(attribute.descriptions) : attribute.descriptions != null)
            return false;
        return productAttributes != null ? productAttributes.equals(attribute.productAttributes) : attribute.productAttributes == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (descriptions != null ? descriptions.hashCode() : 0);
        result = 31 * result + (productAttributes != null ? productAttributes.hashCode() : 0);
        return result;
    }
}
