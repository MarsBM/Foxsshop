package service.interfaces;

import java.util.List;

/**
 * Created by Mars on 18.08.2016.
 */
public interface CrudService<T> {

    List<T> list();

    List<T> list(int firstResult, int maxResults);

    List<T> list(String searchString);

    List<T> list(int firstResult, int maxResults, String searchString);

    List<T> list(String sortBy, String sortMethod);

    List<T> list(int firstResult, int maxResults, String sortBy, String sortMethod);

    List<T> list(String searchString, String sortBy, String sortMethod);

    List<T> list(int firstResult, int maxResults, String searchString, String sortBy, String sortMethod);

    T get(Object o);

    void delete(Object o);

    void save(T t);

    void update(T t);

    Long count();

    Long count(String searchString);
}
