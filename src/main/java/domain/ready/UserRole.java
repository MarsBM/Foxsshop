package domain.ready;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

/**
 * Created by Mars on 11.08.2016.
 */
@Entity
@Table(name = "UserRole")
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", unique = true, length = 25)
    @NotNull
    @Size(min = 2, max = 25)
    private String name;

    @Column(name = "permission", length = 25)
    @NotNull
    @Size(min = 2, max = 25)
    private String permission;

    @OneToMany(mappedBy = "userRole")
    private Set<User> users;

    public UserRole() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Set<User> getUser() {
        return users;
    }

    public void setUser(Set<User> users) {
        this.users = users;
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