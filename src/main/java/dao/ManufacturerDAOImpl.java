package dao;

import dao.interfaces.CrudDAO;
import domain.manufacturer.Manufacturer;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Mars on 10.10.2016.
 */
@Repository
public class ManufacturerDAOImpl implements CrudDAO<Manufacturer> {

    @Autowired
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    @Override
    public List<Manufacturer> list() {
        return sessionFactory.getCurrentSession().createQuery("from Manufacturer").list();
    }

    @Override
    public List<Manufacturer> list(int firstResult, int maxResults) {
        return null;
    }

    @Override
    public List<Manufacturer> list(String searchString) {
        return null;
    }

    @Override
    public List<Manufacturer> list(int firstResult, int maxResults, String searchString) {
        return null;
    }

    @Override
    public List<Manufacturer> list(String sortBy, boolean desc) {
        return null;
    }

    @Override
    public List<Manufacturer> list(int firstResult, int maxResults, String sortBy, boolean desc) {
        return null;
    }

    @Override
    public List<Manufacturer> list(String searchString, String sortBy, boolean desc) {
        return null;
    }

    @Override
    public List<Manufacturer> list(int firstResult, int maxResults, String searchString, String sortBy, boolean desc) {
        return null;
    }

    @Override
    public Manufacturer get(Object o) {
        return null;
    }

    @Override
    public void delete(Object o) {

    }

    @Override
    public void save(Manufacturer manufacturer) {

    }

    @Override
    public void update(Manufacturer manufacturer) {

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
