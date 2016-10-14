package domain.localization;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by Mars on 25.09.2016.
 */
@Entity
public class Language implements Serializable {

    @Column(name = "name")
    private String name;

    @Id
    @Column(name = "code")
    private String code;

    @Column(name = "image")
    private String image;

    @Column(name = "enabled")
    private Boolean enabled;

    public Language() {
    }

    public Language(String name, String code, String image, Boolean enabled) {
        this.name = name;
        this.code = code;
        this.image = image;
        this.enabled = enabled;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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

        Language language = (Language) o;

        if (name != null ? !name.equals(language.name) : language.name != null) return false;
        if (code != null ? !code.equals(language.code) : language.code != null) return false;
        if (image != null ? !image.equals(language.image) : language.image != null) return false;
        return enabled != null ? enabled.equals(language.enabled) : language.enabled == null;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (code != null ? code.hashCode() : 0);
        result = 31 * result + (image != null ? image.hashCode() : 0);
        result = 31 * result + (enabled != null ? enabled.hashCode() : 0);
        return result;
    }
}
