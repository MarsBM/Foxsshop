package dao;

import domain.User;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Mars on 11.08.2016.
 */
@Repository
public class UserDAOImpl implements UserDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public User getUser(String name) {
        return sessionFactory.getCurrentSession().get(User.class, name);
    }

    @Override
    public void updateUser(User user) {
        sessionFactory.getCurrentSession().update(user);
    }

    @Override
    public void removeUser(String name) {
        User user = sessionFactory.getCurrentSession().load(User.class, name);
        if (null != user) {
            sessionFactory.getCurrentSession().delete(user);
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<User> getUserList() {
        return sessionFactory.getCurrentSession().createQuery("from User").list();
    }

    @Override
    public void addContact(User user) {
        sessionFactory.getCurrentSession().save(user);
    }
}
