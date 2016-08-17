package web;

import domain.ready.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.interfaces.UserService;

/**
 * Created by Mars on 11.08.2016.
 */
@Controller
public class HomeController {

    @Autowired
    private UserService userService;

    @Autowired
    SessionFactory sessionFactory;

    @RequestMapping(value = "/")
    public String homePage(Model model) {
        return "index";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addUser(@ModelAttribute User user, Model model) {

        return "redirect:/";
    }
}