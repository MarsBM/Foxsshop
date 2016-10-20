package service;

import dao.interfaces.CrudDAO;
import domain.order.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.interfaces.CrudService;

import java.util.List;

/**
 * Created by Mars on 20.10.2016.
 */
@Service("orderService")
@Transactional
public class OrderServiceImpl implements CrudService<Order> {

    @Autowired
    private CrudDAO<Order> crudDAO;

    @Override
    public List<Order> list() {
        return crudDAO.list();
    }

    @Override
    public List<Order> list(int firstResult, int maxResults) {
        return crudDAO.list(firstResult, maxResults);
    }

    @Override
    public List<Order> list(String searchString) {
        return crudDAO.list(searchString);
    }

    @Override
    public List<Order> list(int firstResult, int maxResults, String searchString) {
        return crudDAO.list(firstResult, maxResults, searchString);
    }

    @Override
    public List<Order> list(String sortBy, boolean desc) {
        return crudDAO.list(sortBy, desc);
    }

    @Override
    public List<Order> list(int firstResult, int maxResults, String sortBy, boolean desc) {
        return crudDAO.list(firstResult, maxResults, sortBy, desc);
    }

    @Override
    public List<Order> list(String searchString, String sortBy, boolean desc) {
        return crudDAO.list(searchString, sortBy, desc);
    }

    @Override
    public List<Order> list(int firstResult, int maxResults, String searchString, String sortBy, boolean desc) {
        return crudDAO.list(firstResult, maxResults, searchString, sortBy, desc);
    }

    @Override
    public Order get(Object o) {
        return crudDAO.get(o);
    }

    @Override
    public void delete(Object o) {
        crudDAO.delete(o);
    }

    @Override
    public void save(Order order) {
        crudDAO.save(order);
    }

    @Override
    public void update(Order order) {
        crudDAO.update(order);
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
