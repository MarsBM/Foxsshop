package dao;

import dao.interfaces.CrudDAO;
import domain.customer.Customer;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Mars on 20.10.2016.
 */
@Repository
public class CustomerDAOImpl implements CrudDAO<Customer> {

    @Autowired
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    @Override
    public List<Customer> list() {
        return sessionFactory.getCurrentSession().createQuery("from Customer").list();
    }

    @Override
    public List<Customer> list(int firstResult, int maxResults) {
        return null;
    }

    @Override
    public List<Customer> list(String searchString) {
        return null;
    }

    @Override
    public List<Customer> list(int firstResult, int maxResults, String searchString) {
        return null;
    }

    @Override
    public List<Customer> list(String sortBy, boolean desc) {
        return null;
    }

    @Override
    public List<Customer> list(int firstResult, int maxResults, String sortBy, boolean desc) {
        return null;
    }

    @Override
    public List<Customer> list(String searchString, String sortBy, boolean desc) {
        return null;
    }

    @Override
    public List<Customer> list(int firstResult, int maxResults, String searchString, String sortBy, boolean desc) {
        return null;
    }

    @Override
    public Customer get(Object o) {
        return null;
    }

    @Override
    public void delete(Object o) {

    }

    @Override
    public void save(Customer customer) {

    }

    @Override
    public void update(Customer customer) {

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
