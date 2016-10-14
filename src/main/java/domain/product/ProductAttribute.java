package domain.product;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Mars on 12.10.2016.
 */
@Embeddable
public class ProductAttribute implements Serializable {

    @ManyToOne
    @JoinColumn(name = "attribute")
    private Attribute attribute;

    @Column(name = "value")
    private String value;

    public ProductAttribute() {
    }

    public ProductAttribute(Attribute attribute, String value) {
        this.attribute = attribute;
        this.value = value;
    }

    public Attribute getAttribute() {
        return attribute;
    }

    public void setAttribute(Attribute attribute) {
        this.attribute = attribute;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductAttribute that = (ProductAttribute) o;

        if (attribute != null ? !attribute.equals(that.attribute) : that.attribute != null) return false;
        return value != null ? value.equals(that.value) : that.value == null;

    }

    @Override
    public int hashCode() {
        int result = attribute != null ? attribute.hashCode() : 0;
        result = 31 * result + (value != null ? value.hashCode() : 0);
        return result;
    }
}
