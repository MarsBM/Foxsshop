package domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * Created by Mars on 12.08.2016.
 */
@Entity
@Table(name = "CustomerGroup")
public class CustomerGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "group")
    @NotNull
    private Integer group;

    @Column(name = "name", unique = true, length = 25)
    @NotNull
    @Size(min = 2, max = 25)
    private String name;

    @Column(name = "language")
    @NotNull
    private Language language;
}
