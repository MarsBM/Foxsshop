package dao.interfaces;

import domain.ready.User;

import java.util.List;

/**
 * Created by Mars on 11.08.2016.
 */
public interface UserDAO {

    List<User> getUsersList();

    User getUser(String login);

    void deleteUser(Long id);

    void updateUser(User user);

    void addUser(User user);
}