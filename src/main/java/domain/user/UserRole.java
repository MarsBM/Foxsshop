package domain.user;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Mars on 18.08.2016.
 */
@Entity
@Table(name = "Roles")
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name", unique = true)
    @NotBlank
    private String name;

    @Column(name = "permission")
    @NotBlank
    private String permission;

    @OneToMany(mappedBy = "userRole")
    private Set<User> users;

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

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserRole userRole = (UserRole) o;

        if (name != null ? !name.equals(userRole.name) : userRole.name != null) return false;
        return permission != null ? permission.equals(userRole.permission) : userRole.permission == null;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (permission != null ? permission.hashCode() : 0);
        return result;
    }

   /* @Override
    public String toString() {
        return name;
    }*/
}
