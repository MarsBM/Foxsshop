package web;

import domain.category.Category;
import domain.localization.Language;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import service.interfaces.CrudService;

import java.lang.reflect.Field;
import java.util.*;

/**
 * Created by Mars on 11.08.2016.
 */
@Controller
public class ControlPanel {

    @Autowired
    private CrudService<Language> languageService;

    @RequestMapping(value = "/")
    public String root() {
        return "redirect:/controlpanel";
    }

    @RequestMapping(value = "/controlpanel")
    public String index(Model model, Locale locale) {
        model.addAttribute("languages", languageService.list());
        model.addAttribute("locale", locale.getLanguage());
        model.addAttribute("activeLang", languageService.get(locale.getLanguage()).getName());
        return "controlpanel";
    }

}