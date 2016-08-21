package dao;

import dao.interfaces.CrudDAO;
import domain.localization.Language;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Mars on 11.08.2016.
 */
@Repository
public class LanguageDAOImpl implements CrudDAO<Language> {

    @Autowired
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    @Override
    public List<Language> list() {
        return sessionFactory.getCurrentSession().createQuery("from Language").list();
    }

    @Override
    public Language get(Object o) {
        return sessionFactory.getCurrentSession().get(Language.class, (Integer) o);
    }

    @Override
    public void delete(Object o) {
        Language language = sessionFactory.getCurrentSession().get(Language.class, (Integer) o);
        if (null != language) {
            sessionFactory.getCurrentSession().delete(language);
        }
    }

    @Override
    public void save(Language language) {
        sessionFactory.getCurrentSession().save(language);
    }

    @Override
    public void update(Language language) {
        sessionFactory.getCurrentSession().update(language);
    }
}
