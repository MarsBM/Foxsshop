package web;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Mars on 11.08.2016.
 */
@Controller
public class ControlPanel {

    @Autowired
    SessionFactory sessionFactory;

    @RequestMapping(value = "/")
    public String root() {
        return "redirect:/controlpanel";
    }

    @RequestMapping(value = "/controlpanel")
    public String index() {
        return "controlpanel";
    }
}