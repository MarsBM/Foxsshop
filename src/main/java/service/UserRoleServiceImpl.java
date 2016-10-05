package service;

import dao.interfaces.CrudDAO;
import domain.user.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.interfaces.CrudService;

import java.util.List;

/**
 * Created by Mars on 18.08.2016.
 */
@Service(value = "roleService")
@Transactional
public class UserRoleServiceImpl implements CrudService<UserRole> {

    @Autowired
    private CrudDAO<UserRole> crudDAO;

    @Override
    public List<UserRole> list() {
        return crudDAO.list();
    }

    @Override
    public List<UserRole> list(int firstResult, int maxResults) {
        return null;
    }

    @Override
    public List<UserRole> list(String searchString) {
        return null;
    }

    @Override
    public List<UserRole> list(int firstResult, int maxResults, String searchString) {
        return null;
    }

    @Override
    public List<UserRole> list(String sortBy, boolean desc) {
        return null;
    }

    @Override
    public List<UserRole> list(int firstResult, int maxResults, String sortBy, boolean desc) {
        return null;
    }

    @Override
    public List<UserRole> list(String searchString, String sortBy, boolean desc) {
        return null;
    }

    @Override
    public List<UserRole> list(int firstResult, int maxResults, String searchString, String sortBy, boolean desc) {
        return crudDAO.list(firstResult, maxResults, searchString, sortBy, desc);
    }

    @Override
    public UserRole get(Object id) {
        return crudDAO.get(id);
    }

    @Override
    public void delete(Object id) {
        crudDAO.delete(id);
    }

    @Override
    public void save(UserRole userRole) {
        crudDAO.save(userRole);
    }

    @Override
    public void update(UserRole userRole) {
        crudDAO.update(userRole);
    }

    @Override
    public Long count() {
        return null;
    }

    @Override
    public Long count(String searchString) {
        return crudDAO.count(searchString);
    }
}
