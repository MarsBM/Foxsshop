package web;

import domain.category.Category;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Mars on 11.08.2016.
 */
@Controller
public class ControlPanel {

    @RequestMapping(value = "/")
    public String root() {
        return "redirect:/controlpanel";
    }

    @RequestMapping(value = "/controlpanel")
    public String index() {
        return "controlpanel";
    }

}