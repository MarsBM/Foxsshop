package dao;

import dao.interfaces.CrudDAO;
import domain.customer.CustomerGroup;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Mars on 20.10.2016.
 */
@Repository
public class CustomerGroupDAOImpl implements CrudDAO<CustomerGroup> {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<CustomerGroup> list() {
        return null;
    }

    @Override
    public List<CustomerGroup> list(int firstResult, int maxResults) {
        return null;
    }

    @Override
    public List<CustomerGroup> list(String searchString) {
        return null;
    }

    @Override
    public List<CustomerGroup> list(int firstResult, int maxResults, String searchString) {
        return null;
    }

    @Override
    public List<CustomerGroup> list(String sortBy, boolean desc) {
        return null;
    }

    @Override
    public List<CustomerGroup> list(int firstResult, int maxResults, String sortBy, boolean desc) {
        return null;
    }

    @Override
    public List<CustomerGroup> list(String searchString, String sortBy, boolean desc) {
        return null;
    }

    @Override
    public List<CustomerGroup> list(int firstResult, int maxResults, String searchString, String sortBy, boolean desc) {
        return null;
    }

    @Override
    public CustomerGroup get(Object o) {
        return null;
    }

    @Override
    public void delete(Object o) {

    }

    @Override
    public void save(CustomerGroup customerGroup) {

    }

    @Override
    public void update(CustomerGroup customerGroup) {

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
