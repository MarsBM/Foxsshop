package service;

import dao.interfaces.CrudDAO;
import domain.customer.CartItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.interfaces.CrudService;

import java.util.List;

/**
 * Created by Mars on 20.10.2016.
 */
@Service("cartItemService")
@Transactional
public class CartItemServiceImpl implements CrudService<CartItem> {

    @Autowired
    private CrudDAO<CartItem> crudDAO;

    @Override
    public List<CartItem> list() {
        return crudDAO.list();
    }

    @Override
    public List<CartItem> list(int firstResult, int maxResults) {
        return crudDAO.list(firstResult, maxResults);
    }

    @Override
    public List<CartItem> list(String searchString) {
        return crudDAO.list(searchString);
    }

    @Override
    public List<CartItem> list(int firstResult, int maxResults, String searchString) {
        return crudDAO.list(firstResult, maxResults, searchString);
    }

    @Override
    public List<CartItem> list(String sortBy, boolean desc) {
        return crudDAO.list(sortBy, desc);
    }

    @Override
    public List<CartItem> list(int firstResult, int maxResults, String sortBy, boolean desc) {
        return crudDAO.list(firstResult, maxResults, sortBy, desc);
    }

    @Override
    public List<CartItem> list(String searchString, String sortBy, boolean desc) {
        return crudDAO.list(searchString, sortBy, desc);
    }

    @Override
    public List<CartItem> list(int firstResult, int maxResults, String searchString, String sortBy, boolean desc) {
        return crudDAO.list(firstResult, maxResults, searchString, sortBy, desc);
    }

    @Override
    public CartItem get(Object o) {
        return crudDAO.get(o);
    }

    @Override
    public void delete(Object o) {
        crudDAO.delete(o);
    }

    @Override
    public void save(CartItem cartItem) {
        crudDAO.save(cartItem);
    }

    @Override
    public void update(CartItem cartItem) {
        crudDAO.update(cartItem);
    }

    @Override
    public Long count() {
        return crudDAO.count();
    }

    @Override
    public Long count(String searchString) {
        return crudDAO.count(searchString);
    }
}
