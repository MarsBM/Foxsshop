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
public class UserRoleServiceImpl implements CrudService<UserRole> {

    @Autowired
    private CrudDAO<UserRole> crudDAO;

    @Override
    @Transactional
    public List<UserRole> list() {
        return crudDAO.list();
    }

    @Override
    @Transactional
    public UserRole get(Object id) {
        return crudDAO.get(id);
    }

    @Override
    @Transactional
    public void delete(Object id) {
        crudDAO.delete(id);
    }

    @Override
    @Transactional
    public void saveOrUpdate(UserRole userRole) {
        crudDAO.saveOrUpdate(userRole);
    }
}
