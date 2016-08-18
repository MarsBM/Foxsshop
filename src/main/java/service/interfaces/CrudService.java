package service.interfaces;

import java.util.List;

/**
 * Created by Mars on 18.08.2016.
 */
public interface CrudService<T> {

    List<T> list();

    T get(Object o);

    void delete(Object o);

    void saveOrUpdate(T t);
}
