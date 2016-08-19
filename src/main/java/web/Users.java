package web;

import domain.user.User;
import domain.user.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import service.interfaces.CrudService;

import javax.validation.Valid;
import java.sql.Date;

/**
 * Created by Mars on 17.08.2016.
 */
@Controller
@RequestMapping(value = "/users")
public class Users {

    @Autowired
    CrudService<User> userService;

    @Autowired
    CrudService<UserRole> roleService;

    @Autowired
    Md5PasswordEncoder md5PasswordEncoder;

    @RequestMapping(value = "/list")
    public String list(Model model) {
        model.addAttribute("users", userService.list());
        return "user/userslist";
    }

    @RequestMapping(value = "/new")
    public String addUser(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("roles", roleService.list());
        model.addAttribute("currentDate", new Date(new java.util.Date().getTime()));
        return "user/useradd";
    }

    @RequestMapping(value = "/delete/{login}")
    public String delete(@PathVariable String login) {
        userService.delete(login);
        return "redirect:/users/list";
    }

    @RequestMapping(value = "/edit/{login}")
    public String edit(@PathVariable String login, Model model) {
        User user = userService.get(login);
        model.addAttribute("user", user);
        model.addAttribute("roles", roleService.list());
        return "user/useredit";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@ModelAttribute User user) {
        String oldPass = userService.get(user.getLogin()).getPassword();
        if (user.getPassword().isEmpty()){
            user.setPassword(oldPass);
        } else user.setPassword(md5PasswordEncoder.encodePassword(user.getPassword(), null));
        userService.saveOrUpdate(user);
        return "redirect:/users/list";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@ModelAttribute @Valid User user, BindingResult result, SessionStatus status, Model model) {

        if (result.hasErrors()) {

            model.addAttribute("user", user);
            model.addAttribute("roles", roleService.list());

            return "user/useradd";

        } else {

            status.setComplete();

            if (null != user){

                String password = md5PasswordEncoder.encodePassword(user.getPassword(), null);
                user.setPassword(password);

                user.setCreateDate(new Date(new java.util.Date().getTime()));

                userService.saveOrUpdate(user);
            }
            return "redirect:/users/list";
        }
    }
}