package service;

import dao.interfaces.CrudDAO;
import domain.user.User;
import domain.user.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.interfaces.CrudService;

import java.util.List;

/**
 * Created by Mars on 15.08.2016.
 */
@Service("userService")
public class UserServiceImpl implements CrudService<User> {

    @Autowired
    private CrudDAO<User> crudDAO;

    @Override
    @Transactional
    public List<User> list() {
        return crudDAO.list();
    }

    @Override
    @Transactional
    public User get(Object login) {
        return crudDAO.get(login);
    }

    @Override
    @Transactional
    public void delete(Object login) {
        crudDAO.delete(login);
    }

    @Override
    @Transactional
    public void save(User user) {
        crudDAO.save(user);
    }

    @Override
    @Transactional
    public void update(User user) {
        crudDAO.update(user);
    }
}
