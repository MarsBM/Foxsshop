package domain;

import javax.persistence.*;

/**
 * Created by Mars on 15.08.2016.
 */

@Entity
public class Test {

    @EmbeddedId
    private emb emb;

    @Column
    private String name;



    public Test() {
    }

    public domain.emb getEmb() {
        return emb;
    }

    public void setEmb(domain.emb emb) {
        this.emb = emb;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
@Embeddable class emb{
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int l_id;
}
