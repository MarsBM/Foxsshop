package dao;

import dao.interfaces.CrudDAO;
import domain.order.OrderItem;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Mars on 20.10.2016.
 */
@Repository
public class OrderItemDAOImpl implements CrudDAO<OrderItem> {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<OrderItem> list() {
        return null;
    }

    @Override
    public List<OrderItem> list(int firstResult, int maxResults) {
        return null;
    }

    @Override
    public List<OrderItem> list(String searchString) {
        return null;
    }

    @Override
    public List<OrderItem> list(int firstResult, int maxResults, String searchString) {
        return null;
    }

    @Override
    public List<OrderItem> list(String sortBy, boolean desc) {
        return null;
    }

    @Override
    public List<OrderItem> list(int firstResult, int maxResults, String sortBy, boolean desc) {
        return null;
    }

    @Override
    public List<OrderItem> list(String searchString, String sortBy, boolean desc) {
        return null;
    }

    @Override
    public List<OrderItem> list(int firstResult, int maxResults, String searchString, String sortBy, boolean desc) {
        return null;
    }

    @Override
    public OrderItem get(Object o) {
        return null;
    }

    @Override
    public void delete(Object o) {

    }

    @Override
    public void save(OrderItem orderItem) {

    }

    @Override
    public void update(OrderItem orderItem) {

    }

    @Override
    public Long count() {
        return null;
    }

    @Override
    public Long count(String searchString) {
        return null;
    }
}
