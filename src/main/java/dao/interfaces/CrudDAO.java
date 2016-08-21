package dao.interfaces;

import java.util.List;

/**
 * Created by Mars on 18.08.2016.
 */
public interface CrudDAO<T> {

    List<T> list();

    T get(Object o);

    void delete(Object o);

    void save(T t);

    void update(T t);

}
