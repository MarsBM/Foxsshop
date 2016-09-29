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

    @SuppressWarnings("unchecked")
    @Override
    public List<Category> list() {
        return sessionFactory.getCurrentSession()
                .createQuery("from Category")
                .list();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Category> list(int firstResult, int maxResults) {
        return sessionFactory.getCurrentSession()
                .createQuery("from Category")
                .setFirstResult(firstResult)
                .setMaxResults(maxResults)
                .list();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Category> list(String searchString) {
        return sessionFactory.getCurrentSession()
                .createQuery("select distinct c from Category c inner join c.descriptions cd where cd.name like :searchString")
                .setParameter("searchString", "%" + searchString + "%")
                .list();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Category> list(int firstResult, int maxResults, String searchString) {
        return sessionFactory.getCurrentSession()
                .createQuery("select distinct c from Category c inner join c.descriptions cd where cd.name like :searchString")
                .setParameter("searchString", "%" + searchString + "%")
                .setFirstResult(firstResult)
                .setMaxResults(maxResults)
                .list();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Category> list(String sortBy, String sortMethod) {
        return sessionFactory.getCurrentSession()
                .createQuery("from Category order by " + sortBy + " " + sortMethod)
                .list();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Category> list(int firstResult, int maxResults, String sortBy, String sortMethod) {
        return sessionFactory.getCurrentSession()
                .createQuery("from Category order by " + sortBy + " " + sortMethod)
                .setFirstResult(firstResult)
                .setMaxResults(maxResults)
                .list();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Category> list(String searchString, String sortBy, String sortMethod) {
        return sessionFactory.getCurrentSession()
                .createQuery("from Category c where c.nameUk like :searchString or c.nameRu like :searchString order by " + sortBy + " " + sortMethod)
                .setParameter("searchString", "%" + searchString + "%")
                .list();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Category> list(int firstResult, int maxResults, String searchString, String sortBy, String sortMethod) {
        return sessionFactory.getCurrentSession()
                .createQuery("select distinct c from Category c inner join c.descriptions cd where cd.name like :searchString order by cd.name"
                        + " " + sortMethod)
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
        return (Long) sessionFactory.getCurrentSession()
                .createQuery("select count(c) from Category c").iterate().next();
    }

    @Override
    public Long count(String searchString) {
        return (Long) sessionFactory.getCurrentSession()
                .createQuery("select count(distinct c) from Category c inner join c.descriptions cd where cd.name like :searchString")
                .setParameter("searchString", "%" + searchString + "%")
                .iterate().next();
    }
}