package dao;

import dao.interfaces.CrudDAO;
import domain.localization.Language;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Mars on 25.09.2016.
 */
@Repository
public class LanguageDAOImpl implements CrudDAO<Language> {

    @Autowired
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    @Override
    public List<Language> list() {
        return sessionFactory.getCurrentSession().createQuery("from Language l").list();
    }

    @Override
    public List<Language> list(int firstResult, int maxResults) {
        return null;
    }

    @Override
    public List<Language> list(String searchString) {
        return null;
    }

    @Override
    public List<Language> list(int firstResult, int maxResults, String searchString) {
        return null;
    }

    @Override
    public List<Language> list(String sortBy, String sortMethod) {
        return null;
    }

    @Override
    public List<Language> list(int firstResult, int maxResults, String sortBy, String sortMethod) {
        return null;
    }

    @Override
    public List<Language> list(String searchString, String sortBy, String sortMethod) {
        return null;
    }

    @Override
    public List<Language> list(int firstResult, int maxResults, String searchString, String sortBy, String sortMethod) {
        return null;
    }

    @Override
    public Language get(Object o) {
        return null;
    }

    @Override
    public void delete(Object o) {

    }

    @Override
    public void save(Language language) {

    }

    @Override
    public void update(Language language) {

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
