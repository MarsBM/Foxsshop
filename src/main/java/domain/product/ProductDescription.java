package domain.product;

import domain.localization.Language;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

/**
 * Created by Mars on 29.09.2016.
 */
@Embeddable
public class ProductDescription implements Serializable {

    @ManyToOne
    @JoinColumn(name = "language")
    private Language language;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    public ProductDescription() {
    }

    public ProductDescription(Language language, String name, String description) {
        this.language = language;
        this.name = name;
        this.description = description;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductDescription that = (ProductDescription) o;

        if (language != null ? !language.equals(that.language) : that.language != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        return description != null ? description.equals(that.description) : that.description == null;

    }

    @Override
    public int hashCode() {
        int result = language != null ? language.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }
}
