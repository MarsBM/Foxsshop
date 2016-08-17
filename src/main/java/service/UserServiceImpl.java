package service;

import dao.interfaces.UserDAO;
import domain.ready.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.interfaces.UserService;

import java.util.List;

/**
 * Created by Mars on 15.08.2016.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    @Transactional
    public List<User> getUsersList() {
        return userDAO.getUsersList();
    }

    @Override
    @Transactional
    public User getUser(String login) {
        return userDAO.getUser(login);
    }

    @Override
    @Transactional
    public void deleteUser(Long id) {
        userDAO.deleteUser(id);
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        userDAO.updateUser(user);
    }

    @Override
    @Transactional
    public void addUser(User user) {
        userDAO.addUser(user);
    }
}
