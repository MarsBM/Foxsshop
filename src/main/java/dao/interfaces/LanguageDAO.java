package dao.interfaces;

import domain.localization.Language;

import java.util.List;

/**
 * Created by Mars on 11.08.2016.
 */
public interface LanguageDAO {

    List getLanguageList();

    Language getLanguage(Integer id);

    void updateLanguage(Language language);

    void removeLanguage(Integer id);

    void addLanguage(Language language);
}