package service;

import dao.interfaces.CrudDAO;
import domain.manufacturer.Manufacturer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.interfaces.CrudService;

import java.util.List;

/**
 * Created by Mars on 10.10.2016.
 */
@Service(value = "manufacturerService")
@Transactional
public class ManufacturerServiceImpl implements CrudService<Manufacturer> {

    @Autowired
    private CrudDAO<Manufacturer> crudDAO;

    @Override
    public List<Manufacturer> list() {
        return crudDAO.list();
    }

    @Override
    public List<Manufacturer> list(int firstResult, int maxResults) {
        return crudDAO.list(firstResult, maxResults);
    }

    @Override
    public List<Manufacturer> list(String searchString) {
        return crudDAO.list(searchString);
    }

    @Override
    public List<Manufacturer> list(int firstResult, int maxResults, String searchString) {
        return crudDAO.list(firstResult, maxResults, searchString);
    }

    @Override
    public List<Manufacturer> list(String sortBy, boolean desc) {
        return crudDAO.list(sortBy, desc);
    }

    @Override
    public List<Manufacturer> list(int firstResult, int maxResults, String sortBy, boolean desc) {
        return crudDAO.list(firstResult, maxResults, sortBy, desc);
    }

    @Override
    public List<Manufacturer> list(String searchString, String sortBy, boolean desc) {
        return crudDAO.list(searchString, sortBy, desc);
    }

    @Override
    public List<Manufacturer> list(int firstResult, int maxResults, String searchString, String sortBy, boolean desc) {
        return crudDAO.list(firstResult, maxResults, searchString, sortBy, desc);
    }

    @Override
    public Manufacturer get(Object o) {
        return crudDAO.get(o);
    }

    @Override
    public void delete(Object o) {
        crudDAO.delete(o);
    }

    @Override
    public void save(Manufacturer manufacturer) {
        crudDAO.save(manufacturer);
    }

    @Override
    public void update(Manufacturer manufacturer) {
        crudDAO.update(manufacturer);
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
