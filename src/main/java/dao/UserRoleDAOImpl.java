package dao;

import dao.interfaces.CrudDAO;
import domain.user.UserRole;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Locale;

/**
 * Created by Mars on 18.08.2016.
 */
@Repository
public class UserRoleDAOImpl implements CrudDAO<UserRole> {

    @Autowired
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    @Override
    public List<UserRole> list() {
        return sessionFactory.getCurrentSession().createQuery("from UserRole").list();
    }

    @Override
    public List<UserRole> list(int firstResult, int maxResults) {
        return null;
    }

    @Override
    public List<UserRole> list(String searchString) {
        return null;
    }

    @Override
    public List<UserRole> list(int firstResult, int maxResults, String searchString) {
        return null;
    }

    @Override
    public List<UserRole> list(String sortBy, boolean desc) {
        return null;
    }

    @Override
    public List<UserRole> list(int firstResult, int maxResults, String sortBy, boolean desc) {
        return null;
    }

    @Override
    public List<UserRole> list(String searchString, String sortBy, boolean desc) {
        return null;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<UserRole> list(int firstResult, int maxResults, String searchString, String sortBy, boolean desc) {
        return sessionFactory.getCurrentSession()
                .createQuery("from UserRole where name like :searchString or permission like :searchString order by " + sortBy + (desc ? " desc" : ""))
                .setParameter("searchString", "%" + searchString + "%")
                .setFirstResult(firstResult)
                .setMaxResults(maxResults)
                .list();
    }

    @Override
    public UserRole get(Object id) {
        return sessionFactory.getCurrentSession().get(UserRole.class, (Integer) id);
    }

    @Override
    public void delete(Object id) {
        UserRole userRole = sessionFactory.getCurrentSession().load(UserRole.class, (Integer) id);
        if (null != userRole) {
            sessionFactory.getCurrentSession().delete(userRole);
        }
    }

    @Override
    public void save(UserRole userRole) {
        sessionFactory.getCurrentSession().save(userRole);
    }

    @Override
    public void update(UserRole userRole) {
        sessionFactory.getCurrentSession().update(userRole);
    }

    @Override
    public Long count() {
        return null;
    }

    @Override
    public Long count(String searchString) {
        return (Long) sessionFactory.getCurrentSession()
                .createQuery("select count(distinct ur) from UserRole ur where ur.name like :searchString or ur.permission like :searchString")
                .setParameter("searchString", "%" + searchString + "%")
                .iterate().next();
    }
}
