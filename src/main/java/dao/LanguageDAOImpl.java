package dao;

import dao.interfaces.LanguageDAO;
import domain.Language;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Mars on 11.08.2016.
 */
public class LanguageDAOImpl implements LanguageDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    @Override
    public List<Language> getLanguageList() {
        return sessionFactory.getCurrentSession().createQuery("from Language").list();
    }

    @Override
    public Language getLanguage(Integer id) {
        return sessionFactory.getCurrentSession().get(Language.class, id);
    }

    @Override
    public void updateLanguage(Language language) {
        sessionFactory.getCurrentSession().update(language);
    }

    @Override
    public void removeLanguage(Integer id) {
        Language language = sessionFactory.getCurrentSession().get(Language.class, id);
        if (null != language) {
            sessionFactory.getCurrentSession().delete(language);
        }
    }

    @Override
    public void addLanguage(Language language) {
        sessionFactory.getCurrentSession().save(language);
    }
}
