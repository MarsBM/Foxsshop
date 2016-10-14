package dao;

import dao.interfaces.CrudDAO;
import domain.product.Attribute;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Mars on 13.10.2016.
 */
@Repository
public class AttributeDAOImpl implements CrudDAO<Attribute> {

    @Autowired
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    @Override
    public List<Attribute> list() {
        return sessionFactory.getCurrentSession().createQuery("from Attribute").list();
    }

    @Override
    public List<Attribute> list(int firstResult, int maxResults) {
        return null;
    }

    @Override
    public List<Attribute> list(String searchString) {
        return null;
    }

    @Override
    public List<Attribute> list(int firstResult, int maxResults, String searchString) {
        return null;
    }

    @Override
    public List<Attribute> list(String sortBy, boolean desc) {
        return null;
    }

    @Override
    public List<Attribute> list(int firstResult, int maxResults, String sortBy, boolean desc) {
        return null;
    }

    @Override
    public List<Attribute> list(String searchString, String sortBy, boolean desc) {
        return null;
    }

    @Override
    public List<Attribute> list(int firstResult, int maxResults, String searchString, String sortBy, boolean desc) {
        return null;
    }

    @Override
    public Attribute get(Object o) {
        return null;
    }

    @Override
    public void delete(Object o) {

    }

    @Override
    public void save(Attribute attribute) {

    }

    @Override
    public void update(Attribute attribute) {

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
