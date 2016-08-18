package dao;

import dao.interfaces.CrudDAO;
import domain.user.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

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
    public void saveOrUpdate(User user) {
        sessionFactory.getCurrentSession().saveOrUpdate(user);
    }
}
