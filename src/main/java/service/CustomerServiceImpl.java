package service;

import dao.interfaces.CrudDAO;
import domain.customer.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import service.interfaces.CrudService;

import java.util.List;

/**
 * Created by Mars on 20.10.2016.
 */
@Repository("customerService")
@Transactional
public class CustomerServiceImpl implements CrudService<Customer> {

    @Autowired
    private CrudDAO<Customer> crudDAO;

    @Override
    public List<Customer> list() {
        return crudDAO.list();
    }

    @Override
    public List<Customer> list(int firstResult, int maxResults) {
        return crudDAO.list(firstResult, maxResults);
    }

    @Override
    public List<Customer> list(String searchString) {
        return crudDAO.list(searchString);
    }

    @Override
    public List<Customer> list(int firstResult, int maxResults, String searchString) {
        return crudDAO.list(firstResult, maxResults, searchString);
    }

    @Override
    public List<Customer> list(String sortBy, boolean desc) {
        return crudDAO.list(sortBy, desc);
    }

    @Override
    public List<Customer> list(int firstResult, int maxResults, String sortBy, boolean desc) {
        return crudDAO.list(firstResult, maxResults, sortBy, desc);
    }

    @Override
    public List<Customer> list(String searchString, String sortBy, boolean desc) {
        return crudDAO.list(searchString, sortBy, desc);
    }

    @Override
    public List<Customer> list(int firstResult, int maxResults, String searchString, String sortBy, boolean desc) {
        return crudDAO.list(firstResult, maxResults, searchString, sortBy, desc);
    }

    @Override
    public Customer get(Object o) {
        return crudDAO.get(o);
    }

    @Override
    public void delete(Object o) {

    }

    @Override
    public void save(Customer customer) {
        crudDAO.save(customer);
    }

    @Override
    public void update(Customer customer) {
        crudDAO.update(customer);
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
