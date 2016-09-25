package domain.category;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Mars on 22.08.2016.
 */
@Entity
public class Category implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nameUk;

    private String descriptionUk;

    private String nameRu;

    private String descriptionRu;

    private String imageFilePath;

    private Boolean enabled = true;

    public Category() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameUk() {
        return nameUk;
    }

    public void setNameUk(String nameUk) {
        this.nameUk = nameUk;
    }

    public String getDescriptionUk() {
        return descriptionUk;
    }

    public void setDescriptionUk(String descriptionUk) {
        this.descriptionUk = descriptionUk;
    }

    public String getNameRu() {
        return nameRu;
    }

    public void setNameRu(String nameRu) {
        this.nameRu = nameRu;
    }

    public String getDescriptionRu() {
        return descriptionRu;
    }

    public void setDescriptionRu(String descriptionRu) {
        this.descriptionRu = descriptionRu;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Category category = (Category) o;

        if (id != null ? !id.equals(category.id) : category.id != null) return false;
        if (nameUk != null ? !nameUk.equals(category.nameUk) : category.nameUk != null) return false;
        if (descriptionUk != null ? !descriptionUk.equals(category.descriptionUk) : category.descriptionUk != null)
            return false;
        if (nameRu != null ? !nameRu.equals(category.nameRu) : category.nameRu != null) return false;
        if (descriptionRu != null ? !descriptionRu.equals(category.descriptionRu) : category.descriptionRu != null)
            return false;
        if (imageFilePath != null ? !imageFilePath.equals(category.imageFilePath) : category.imageFilePath != null)
            return false;
        return enabled != null ? enabled.equals(category.enabled) : category.enabled == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (nameUk != null ? nameUk.hashCode() : 0);
        result = 31 * result + (descriptionUk != null ? descriptionUk.hashCode() : 0);
        result = 31 * result + (nameRu != null ? nameRu.hashCode() : 0);
        result = 31 * result + (descriptionRu != null ? descriptionRu.hashCode() : 0);
        result = 31 * result + (imageFilePath != null ? imageFilePath.hashCode() : 0);
        result = 31 * result + (enabled != null ? enabled.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", nameUk='" + nameUk + '\'' +
                ", descriptionUk='" + descriptionUk + '\'' +
                ", nameRu='" + nameRu + '\'' +
                ", descriptionRu='" + descriptionRu + '\'' +
                ", imageFilePath='" + imageFilePath + '\'' +
                ", enabled=" + enabled +
                '}';
    }
}