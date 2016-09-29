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
}
