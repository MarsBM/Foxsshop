package dao;

import dao.interfaces.CrudDAO;
import domain.category.Category;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Mars on 23.08.2016.
 */
@Repository
public class CategoryDAOImpl implements CrudDAO<Category> {

    @Autowired
    SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    @Override
    public List<Category> list() {
        return sessionFactory.getCurrentSession().createQuery("from Category").list();
    }

    @Override
    public Category get(Object o) {
        return sessionFactory.getCurrentSession().get(Category.class, (Long) o);
    }

    @Override
    public void delete(Object o) {
        Category category = sessionFactory.getCurrentSession().get(Category.class, (Long) o);
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
}
