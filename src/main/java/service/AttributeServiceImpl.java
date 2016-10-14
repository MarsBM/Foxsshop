package service;

import dao.interfaces.CrudDAO;
import domain.product.Attribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.interfaces.CrudService;

import java.util.List;

/**
 * Created by Mars on 13.10.2016.
 */
@Service("attributeService")
@Transactional
public class AttributeServiceImpl implements CrudService<Attribute> {

    @Autowired
    private CrudDAO<Attribute> crudDAO;

    @Override
    public List<Attribute> list() {
        return crudDAO.list();
    }

    @Override
    public List<Attribute> list(int firstResult, int maxResults) {
        return crudDAO.list(firstResult, maxResults);
    }

    @Override
    public List<Attribute> list(String searchString) {
        return crudDAO.list(searchString);
    }

    @Override
    public List<Attribute> list(int firstResult, int maxResults, String searchString) {
        return crudDAO.list(firstResult, maxResults, searchString);
    }

    @Override
    public List<Attribute> list(String sortBy, boolean desc) {
        return crudDAO.list(sortBy, desc);
    }

    @Override
    public List<Attribute> list(int firstResult, int maxResults, String sortBy, boolean desc) {
        return crudDAO.list(firstResult, maxResults, sortBy, desc);
    }

    @Override
    public List<Attribute> list(String searchString, String sortBy, boolean desc) {
        return crudDAO.list(searchString, sortBy, desc);
    }

    @Override
    public List<Attribute> list(int firstResult, int maxResults, String searchString, String sortBy, boolean desc) {
        return crudDAO.list(firstResult, maxResults, searchString, sortBy, desc);
    }

    @Override
    public Attribute get(Object o) {
        return crudDAO.get(o);
    }

    @Override
    public void delete(Object o) {
        crudDAO.delete(o);
    }

    @Override
    public void save(Attribute attribute) {
        crudDAO.save(attribute);
    }

    @Override
    public void update(Attribute attribute) {
        crudDAO.update(attribute);
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
