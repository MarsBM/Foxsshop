package service;

import dao.interfaces.CrudDAO;
import domain.customer.CustomerGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.interfaces.CrudService;

import java.util.List;

/**
 * Created by Mars on 20.10.2016.
 */
@Service("customerGroupService")
@Transactional
public class CustomerGroupServiceImpl implements CrudService<CustomerGroup> {

    @Autowired
    private CrudDAO<CustomerGroup> crudDAO;

    @Override
    public List<CustomerGroup> list() {
        return crudDAO.list();
    }

    @Override
    public List<CustomerGroup> list(int firstResult, int maxResults) {
        return crudDAO.list(firstResult, maxResults);
    }

    @Override
    public List<CustomerGroup> list(String searchString) {
        return crudDAO.list(searchString);
    }

    @Override
    public List<CustomerGroup> list(int firstResult, int maxResults, String searchString) {
        return crudDAO.list(firstResult, maxResults, searchString);
    }

    @Override
    public List<CustomerGroup> list(String sortBy, boolean desc) {
        return crudDAO.list(sortBy, desc);
    }

    @Override
    public List<CustomerGroup> list(int firstResult, int maxResults, String sortBy, boolean desc) {
        return crudDAO.list(firstResult, maxResults, sortBy, desc);
    }

    @Override
    public List<CustomerGroup> list(String searchString, String sortBy, boolean desc) {
        return crudDAO.list(searchString, sortBy, desc);
    }

    @Override
    public List<CustomerGroup> list(int firstResult, int maxResults, String searchString, String sortBy, boolean desc) {
        return crudDAO.list(firstResult, maxResults, searchString, sortBy, desc);
    }

    @Override
    public CustomerGroup get(Object o) {
        return crudDAO.get(o);
    }

    @Override
    public void delete(Object o) {
        crudDAO.delete(o);
    }

    @Override
    public void save(CustomerGroup customerGroup) {
        crudDAO.save(customerGroup);
    }

    @Override
    public void update(CustomerGroup customerGroup) {
        crudDAO.update(customerGroup);
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
