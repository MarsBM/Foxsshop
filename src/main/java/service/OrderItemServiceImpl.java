package service;

import dao.interfaces.CrudDAO;
import domain.order.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.interfaces.CrudService;

import java.util.List;

/**
 * Created by Mars on 20.10.2016.
 */
@Service("orderItemService")
@Transactional
public class OrderItemServiceImpl implements CrudService<OrderItem> {

    @Autowired
    private CrudDAO<OrderItem> crudDAO;

    @Override
    public List<OrderItem> list() {
        return crudDAO.list();
    }

    @Override
    public List<OrderItem> list(int firstResult, int maxResults) {
        return crudDAO.list(firstResult, maxResults);
    }

    @Override
    public List<OrderItem> list(String searchString) {
        return crudDAO.list(searchString);
    }

    @Override
    public List<OrderItem> list(int firstResult, int maxResults, String searchString) {
        return crudDAO.list(firstResult, maxResults, searchString);
    }

    @Override
    public List<OrderItem> list(String sortBy, boolean desc) {
        return crudDAO.list(sortBy, desc);
    }

    @Override
    public List<OrderItem> list(int firstResult, int maxResults, String sortBy, boolean desc) {
        return crudDAO.list(firstResult, maxResults, sortBy, desc);
    }

    @Override
    public List<OrderItem> list(String searchString, String sortBy, boolean desc) {
        return crudDAO.list(searchString, sortBy, desc);
    }

    @Override
    public List<OrderItem> list(int firstResult, int maxResults, String searchString, String sortBy, boolean desc) {
        return crudDAO.list(firstResult, maxResults, searchString, sortBy, desc);
    }

    @Override
    public OrderItem get(Object o) {
        return crudDAO.get(o);
    }

    @Override
    public void delete(Object o) {
        crudDAO.delete(o);
    }

    @Override
    public void save(OrderItem orderItem) {
        crudDAO.save(orderItem);
    }

    @Override
    public void update(OrderItem orderItem) {
        crudDAO.update(orderItem);
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
