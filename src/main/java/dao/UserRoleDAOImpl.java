package dao;

import dao.interfaces.CrudDAO;
import domain.user.UserRole;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

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
    public void saveOrUpdate(UserRole userRole) {
        sessionFactory.getCurrentSession().saveOrUpdate(userRole);
    }
}
