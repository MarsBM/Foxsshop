package service;

import dao.interfaces.CrudDAO;
import domain.localization.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.interfaces.CrudService;

import java.util.List;

/**
 * Created by Mars on 25.09.2016.
 */
@Service(value = "languageService")
@Transactional
public class LanguageServiceImpl implements CrudService<Language>{

    @Autowired
    private CrudDAO<Language> crudDAO;

    @Override
    public List<Language> list() {
        return crudDAO.list();
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
    public List<Language> list(String sortBy, boolean desc) {
        return null;
    }

    @Override
    public List<Language> list(int firstResult, int maxResults, String sortBy, boolean desc) {
        return null;
    }

    @Override
    public List<Language> list(String searchString, String sortBy, boolean desc) {
        return null;
    }

    @Override
    public List<Language> list(int firstResult, int maxResults, String searchString, String sortBy, boolean desc) {
        return null;
    }

    @Override
    public Language get(Object o) {
        return crudDAO.get(o);
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
