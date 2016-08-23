package domain.category;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Mars on 22.08.2016.
 */
@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Category parent;

    @OneToMany(mappedBy = "category")
    private List<CategoryDescription> descriptions;

    public Category() {
    }
}