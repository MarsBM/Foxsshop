package domain.localization;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Locale;

/**
 * Created by Mars on 11.08.2016.
 */
@Entity
@Table(name = "Languages")
public class Language {

    @Column(name = "name",unique = true, length = 20)
    @NotBlank
    @Size(min = 2, max = 20)
    private String name;

    @Id
    @Column(name = "code",unique = true)
    @NotBlank
    private String locale;

    @Column(name = "image")
    private String image;

    public Language() {
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
