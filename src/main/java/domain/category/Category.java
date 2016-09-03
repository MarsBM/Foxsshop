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

    private Long parentCategoryId;

    @NotBlank
    private String nameUk;

    @NotBlank
    private String descriptionUk;

    @NotBlank
    private String nameRu;

    @NotBlank
    private String descriptionRu;

    @NotBlank
    private String imageFilePath;

    private Boolean isEnabled;

    private Boolean isTop;

    private Long sortOrder;

    public Category() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParentCategoryId() {
        return parentCategoryId;
    }

    public void setParentCategoryId(Long parentCategoryId) {
        this.parentCategoryId = parentCategoryId;
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
        return isEnabled;
    }

    public void setEnabled(Boolean enabled) {
        isEnabled = enabled;
    }

    public Boolean getTop() {
        return isTop;
    }

    public void setTop(Boolean top) {
        isTop = top;
    }

    public Long getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Long sortOrder) {
        this.sortOrder = sortOrder;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Category category = (Category) o;

        if (id != null ? !id.equals(category.id) : category.id != null) return false;
        if (parentCategoryId != null ? !parentCategoryId.equals(category.parentCategoryId) : category.parentCategoryId != null)
            return false;
        if (nameUk != null ? !nameUk.equals(category.nameUk) : category.nameUk != null) return false;
        if (descriptionUk != null ? !descriptionUk.equals(category.descriptionUk) : category.descriptionUk != null)
            return false;
        if (nameRu != null ? !nameRu.equals(category.nameRu) : category.nameRu != null) return false;
        if (descriptionRu != null ? !descriptionRu.equals(category.descriptionRu) : category.descriptionRu != null)
            return false;
        if (imageFilePath != null ? !imageFilePath.equals(category.imageFilePath) : category.imageFilePath != null)
            return false;
        if (isEnabled != null ? !isEnabled.equals(category.isEnabled) : category.isEnabled != null) return false;
        if (isTop != null ? !isTop.equals(category.isTop) : category.isTop != null) return false;
        return sortOrder != null ? sortOrder.equals(category.sortOrder) : category.sortOrder == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (parentCategoryId != null ? parentCategoryId.hashCode() : 0);
        result = 31 * result + (nameUk != null ? nameUk.hashCode() : 0);
        result = 31 * result + (descriptionUk != null ? descriptionUk.hashCode() : 0);
        result = 31 * result + (nameRu != null ? nameRu.hashCode() : 0);
        result = 31 * result + (descriptionRu != null ? descriptionRu.hashCode() : 0);
        result = 31 * result + (imageFilePath != null ? imageFilePath.hashCode() : 0);
        result = 31 * result + (isEnabled != null ? isEnabled.hashCode() : 0);
        result = 31 * result + (isTop != null ? isTop.hashCode() : 0);
        result = 31 * result + (sortOrder != null ? sortOrder.hashCode() : 0);
        return result;
    }
}