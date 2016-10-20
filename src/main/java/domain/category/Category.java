package domain.category;

import domain.product.Product;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.Valid;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by Mars on 22.08.2016.
 */
@Entity
@Table(name = "category_")
public class Category implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_")
    private Integer id;

    @ElementCollection
    @CollectionTable(
            name="category_descriptions",
            joinColumns=@JoinColumn(name="category_")
    )
    @Valid
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<CategoryDescription> descriptions;

    @Column(name = "image_file_path_")
    private String imageFilePath;

    @Column(name = "enabled_")
    private Boolean enabled = true;

    @ManyToMany(mappedBy = "categories")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Product> products = new ArrayList<>();

    public Category() {
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImageFilePath() {
        return imageFilePath;
    }

    public void setImageFilePath(String imageFilePath) {
        this.imageFilePath = imageFilePath;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public List<CategoryDescription> getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(List<CategoryDescription> descriptions) {
        this.descriptions = descriptions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Category category = (Category) o;

        if (id != null ? !id.equals(category.id) : category.id != null) return false;
        if (descriptions != null ? !descriptions.equals(category.descriptions) : category.descriptions != null)
            return false;
        if (imageFilePath != null ? !imageFilePath.equals(category.imageFilePath) : category.imageFilePath != null)
            return false;
        return enabled != null ? enabled.equals(category.enabled) : category.enabled == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (descriptions != null ? descriptions.hashCode() : 0);
        result = 31 * result + (imageFilePath != null ? imageFilePath.hashCode() : 0);
        result = 31 * result + (enabled != null ? enabled.hashCode() : 0);
        return result;
    }
}