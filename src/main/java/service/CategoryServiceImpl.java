package service;

import dao.interfaces.CrudDAO;
import domain.category.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.interfaces.CrudService;

import java.util.List;

/**
 * Created by Mars on 23.08.2016.
 */
@Service(value = "categoryService")
@Transactional
public class CategoryServiceImpl implements CrudService<Category> {

    @Autowired
    CrudDAO<Category> crudDAO;

    @Override
    public List<Category> list() {
        return crudDAO.list();
    }

    @Override
    public Category get(Object o) {
        return crudDAO.get(o);
    }

    @Override
    public void delete(Object o) {
        crudDAO.delete(o);
    }

    @Override
    public void save(Category category) {
        crudDAO.save(category);
    }

    @Override
    public void update(Category category) {
        crudDAO.update(category);
    }
}
