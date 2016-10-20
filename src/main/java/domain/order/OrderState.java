package domain.order;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import javax.validation.Valid;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Mars on 20.10.2016.
 */
@Entity
@Table(name = "order_state")
public class OrderState implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_")
    private Integer id;

    @ElementCollection
    @CollectionTable(
            name="order_state_descriptions",
            joinColumns=@JoinColumn(name="order_state_")
    )
    @Valid
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<OrderStateDescription> descriptions;

    @OneToMany(mappedBy = "state")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<OrderStateItem> orderStateItems;

    public OrderState() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<OrderStateDescription> getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(List<OrderStateDescription> descriptions) {
        this.descriptions = descriptions;
    }

    public List<OrderStateItem> getOrderStateItems() {
        return orderStateItems;
    }

    public void setOrderStateItems(List<OrderStateItem> orderStateItems) {
        this.orderStateItems = orderStateItems;
    }
}
