package dao;

import dao.interfaces.CrudDAO;
import domain.user.User;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Locale;

/**
 * Created by Mars on 11.08.2016.
 */
@Repository
public class UserDAOImpl implements CrudDAO<User> {

    @Autowired
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    @Override
    public List<User> list() {
        return sessionFactory.getCurrentSession().createQuery("from User").list();
    }

    @Override
    public List<User> list(int firstResult, int maxResults) {
        return null;
    }

    @Override
    public List<User> list(String searchString) {
        return null;
    }

    @Override
    public List<User> list(int firstResult, int maxResults, String searchString) {
        return null;
    }

    @Override
    public List<User> list(String sortBy, String sortMethod) {
        return null;
    }

    @Override
    public List<User> list(int firstResult, int maxResults, String sortBy, String sortMethod) {
        return null;
    }

    @Override
    public List<User> list(String searchString, String sortBy, String sortMethod) {
        return null;
    }

    @Override
    public List<User> list(int firstResult, int maxResults, String searchString, String sortBy, String sortMethod) {
        return null;
    }

    @Override
    public User get(Object login) {
        return sessionFactory.getCurrentSession().get(User.class, (String) login);
    }

    @Override
    public void delete(Object login) {
        User user = sessionFactory.getCurrentSession().load(User.class, (String) login);
        if (null != user) {
            sessionFactory.getCurrentSession().delete(user);
        }
    }

    @Override
    public void save(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    public void update(User user) {
        sessionFactory.getCurrentSession().update(user);
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
