package service;

import dao.interfaces.CrudDAO;
import domain.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Mars on 11.08.2016.
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private CrudDAO<User> crudDAO;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {

        User user = crudDAO.get(login);

        if (null == user) {
            throw new UsernameNotFoundException("USER NOT FOUND!");
        }

        Set<GrantedAuthority> roles = new HashSet<>();

        roles.add(new SimpleGrantedAuthority(user.getUserRole().getPermission()));

        UserDetails userDetails = new org.springframework.security.core.userdetails
                .User(user.getLogin(), user.getPassword(), user.getEnabled(), true, true, true, roles);
        return userDetails;
    }
}