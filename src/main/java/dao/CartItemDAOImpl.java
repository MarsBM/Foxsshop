package dao;

import dao.interfaces.CrudDAO;
import domain.customer.CartItem;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Mars on 20.10.2016.
 */
@Repository
public class CartItemDAOImpl implements CrudDAO<CartItem> {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<CartItem> list() {
        return null;
    }

    @Override
    public List<CartItem> list(int firstResult, int maxResults) {
        return null;
    }

    @Override
    public List<CartItem> list(String searchString) {
        return null;
    }

    @Override
    public List<CartItem> list(int firstResult, int maxResults, String searchString) {
        return null;
    }

    @Override
    public List<CartItem> list(String sortBy, boolean desc) {
        return null;
    }

    @Override
    public List<CartItem> list(int firstResult, int maxResults, String sortBy, boolean desc) {
        return null;
    }

    @Override
    public List<CartItem> list(String searchString, String sortBy, boolean desc) {
        return null;
    }

    @Override
    public List<CartItem> list(int firstResult, int maxResults, String searchString, String sortBy, boolean desc) {
        return null;
    }

    @Override
    public CartItem get(Object o) {
        return null;
    }

    @Override
    public void delete(Object o) {

    }

    @Override
    public void save(CartItem cartItem) {

    }

    @Override
    public void update(CartItem cartItem) {

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
