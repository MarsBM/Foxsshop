package domain.category;

import domain.localization.Language;

import javax.persistence.*;

/**
 * Created by Mars on 23.08.2016.
 */
@Entity
public class CategoryDescription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn
    private Category category;

    private Language language;
    private String name;
    private String description;
    private String image;
}
