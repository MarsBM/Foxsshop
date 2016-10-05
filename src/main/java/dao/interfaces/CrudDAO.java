package dao.interfaces;

import java.util.List;
import java.util.Locale;

/**
 * Created by Mars on 18.08.2016.
 */
public interface CrudDAO<T> {

    List<T> list();

    List<T> list(int firstResult, int maxResults);

    List<T> list(String searchString);

    List<T> list(int firstResult, int maxResults, String searchString);

    List<T> list(String sortBy, boolean desc);

    List<T> list(int firstResult, int maxResults, String sortBy, boolean desc);

    List<T> list(String searchString, String sortBy, boolean desc);

    List<T> list(int firstResult, int maxResults, String searchString, String sortBy, boolean desc);

    T get(Object o);

    void delete(Object o);

    void save(T t);

    void update(T t);

    Long count();

    Long count(String searchString);

}
