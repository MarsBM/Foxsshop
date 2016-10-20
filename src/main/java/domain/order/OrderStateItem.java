package domain.order;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Mars on 20.10.2016.
 */
@Entity
public class OrderStateItem implements Serializable{

    @Id
    @ManyToOne
    @JoinColumn(name = "order_")
    private Order order;

    @Id
    @ManyToOne
    @JoinColumn(name = "state_")
    private OrderState state;

    private Date date;

    private String comment;

    public OrderStateItem() {
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public OrderState getState() {
        return state;
    }

    public void setState(OrderState state) {
        this.state = state;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
