package dao;

import dao.interfaces.CrudDAO;
import domain.category.Category;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.io.Serializable;
import java.util.List;
import java.util.Locale;

import static sun.security.krb5.Confounder.intValue;

/**
 * Created by Mars on 23.08.2016.
 */
@Repository
public class CategoryDAOImpl implements CrudDAO<Category> {

    @Autowired
    private SessionFactory sessionFactory;

    private final String QUERY1 = "from Category";
    private final String QUERY2 = "select distinct c from Category c inner join c.descriptions cd where cd.name like :searchString";
    private final String QUERY3 = "select count(distinct c) from Category c inner join c.descriptions cd where cd.name like :searchString";

    @SuppressWarnings("unchecked")
    @Override
    public List<Category> list() {
        return sessionFactory.getCurrentSession()
                .createQuery(QUERY1)
                .list();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Category> list(int firstResult, int maxResults) {
        return sessionFactory.getCurrentSession()
                .createQuery(QUERY1)
                .setFirstResult(firstResult)
                .setMaxResults(maxResults)
                .list();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Category> list(String searchString) {
        return sessionFactory.getCurrentSession()
                .createQuery(QUERY2)
                .setParameter("searchString", "%" + searchString + "%")
                .list();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Category> list(int firstResult, int maxResults, String searchString) {
        return sessionFactory.getCurrentSession()
                .createQuery(QUERY2)
                .setParameter("searchString", "%" + searchString + "%")
                .setFirstResult(firstResult)
                .setMaxResults(maxResults)
                .list();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Category> list(String sortBy, boolean desc) {
        return null;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Category> list(int firstResult, int maxResults, String sortBy, boolean desc) {
        return null;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Category> list(String searchString, String sortBy, boolean desc) {
        return null;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Category> list(int firstResult, int maxResults, String searchString, String sortBy, boolean desc) {
        return sessionFactory.getCurrentSession()
                .createQuery(QUERY2 + " order by cd.name" + (desc ? " desc" : " "))
                .setParameter("searchString", "%" + searchString + "%")
                .setFirstResult(firstResult)
                .setMaxResults(maxResults)
                .list();
    }

    @SuppressWarnings("unchecked")
    @Override
    public Category get(Object o) {
        return sessionFactory.getCurrentSession().get(Category.class, (Integer) o);
    }

    @Override
    public void delete(Object o) {
        Category category = sessionFactory.getCurrentSession().get(Category.class, (Integer) o);
        if (null != category) {
            sessionFactory.getCurrentSession().delete(category);
        }
    }

    @Override
    public void save(Category category) {
        sessionFactory.getCurrentSession().save(category);
    }

    @Override
    public void update(Category category) {
        sessionFactory.getCurrentSession().update(category);
    }

    @Override
    public Long count() {
        return null;
    }

    @Override
    public Long count(String searchString) {
        return (Long) sessionFactory.getCurrentSession()
                .createQuery(QUERY3)
                .setParameter("searchString", "%" + searchString + "%")
                .iterate().next();
    }
}