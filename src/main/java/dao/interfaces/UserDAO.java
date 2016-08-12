package dao.interfaces;

import domain.User;

import java.util.List;

/**
 * Created by Mars on 11.08.2016.
 */
public interface UserDAO {

    User getUser(String name);

    void updateUser(User user);

    void removeUser(String name);

    List<User> getUserList();

    void addContact(User user);
}