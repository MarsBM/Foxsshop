package domain;

import javax.persistence.*;

/**
 * Created by Mars on 11.08.2016.
 */
@Entity
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    private String name;

    @Column
    private String permission;

    public UserRole() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserRole userRole = (UserRole) o;

        if (!name.equals(userRole.name)) return false;
        return permission.equals(userRole.permission);

    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + permission.hashCode();
        return result;
    }
}