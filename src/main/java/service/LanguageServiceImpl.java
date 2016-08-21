package service;

import dao.interfaces.CrudDAO;
import domain.localization.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.interfaces.CrudService;

import java.util.List;

/**
 * Created by Mars on 19.08.2016.
 */
@Service(value = "languageService")
public class LanguageServiceImpl implements CrudService<Language> {

    @Autowired
    CrudDAO<Language> crudDAO;


    @Override
    @Transactional
    public List<Language> list() {
        return crudDAO.list();
    }

    @Override
    @Transactional
    public Language get(Object o) {
        return crudDAO.get(o);
    }

    @Override
    @Transactional
    public void delete(Object o) {
        crudDAO.delete(o);
    }

    @Override
    @Transactional
    public void save(Language language) {
        crudDAO.save(language);
    }

    @Override
    @Transactional
    public void update(Language language) {
        crudDAO.update(language);
    }
}