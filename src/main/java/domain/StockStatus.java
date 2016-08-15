package domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by Mars on 15.08.2016.
 */

@Entity
@Table(name = "StockStatus")
public class StockStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "statusId")
    @NotNull
    private Integer statusId;

    @Column(name = "language")
    @NotNull
    private Language language;

    @Column(name = "name", length = 25, unique = true)
    @NotNull
    @Size(min = 2, max = 25)
    private String name;

    public StockStatus() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StockStatus that = (StockStatus) o;

        if (!statusId.equals(that.statusId)) return false;
        if (!language.equals(that.language)) return false;
        return name.equals(that.name);

    }

    @Override
    public int hashCode() {
        int result = statusId.hashCode();
        result = 31 * result + language.hashCode();
        result = 31 * result + name.hashCode();
        return result;
    }
}
