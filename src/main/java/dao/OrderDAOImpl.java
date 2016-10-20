package dao;

import dao.interfaces.CrudDAO;
import domain.order.Order;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Mars on 20.10.2016.
 */
@Repository
public class OrderDAOImpl implements CrudDAO<Order> {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Order> list() {
        return null;
    }

    @Override
    public List<Order> list(int firstResult, int maxResults) {
        return null;
    }

    @Override
    public List<Order> list(String searchString) {
        return null;
    }

    @Override
    public List<Order> list(int firstResult, int maxResults, String searchString) {
        return null;
    }

    @Override
    public List<Order> list(String sortBy, boolean desc) {
        return null;
    }

    @Override
    public List<Order> list(int firstResult, int maxResults, String sortBy, boolean desc) {
        return null;
    }

    @Override
    public List<Order> list(String searchString, String sortBy, boolean desc) {
        return null;
    }

    @Override
    public List<Order> list(int firstResult, int maxResults, String searchString, String sortBy, boolean desc) {
        return null;
    }

    @Override
    public Order get(Object o) {
        return null;
    }

    @Override
    public void delete(Object o) {

    }

    @Override
    public void save(Order order) {

    }

    @Override
    public void update(Order order) {

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
