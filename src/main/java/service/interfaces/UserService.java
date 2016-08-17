package service.interfaces;

import domain.ready.User;

import java.util.List;

/**
 * Created by Mars on 15.08.2016.
 */
public interface UserService {

    List<User> getUsersList();

    User getUser(String login);

    void deleteUser(Long id);

    void updateUser(User user);

    void addUser(User user);
}
