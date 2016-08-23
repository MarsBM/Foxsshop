package web;

import domain.localization.Language;
import org.springframework.beans.factory.annotation.Autowired;
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
import java.util.Locale;

/**
 * Created by Mars on 19.08.2016.
 */
@Controller
@RequestMapping(value = "/languages")
public class Languages {

    @Autowired
    private CrudService<Language> languageService;

    @RequestMapping(value = "/list")
    public String list(Model model) {
        model.addAttribute("languages", languageService.list());
        return "language/languageslist";
    }

    @RequestMapping(value = "/new")
    public String addUser(Model model) {
        model.addAttribute("language", new Language());
        return "language/languageadd";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@ModelAttribute @Valid Language language, BindingResult result, SessionStatus status, Model model) {

        if (result.hasErrors()) {

            model.addAttribute("language", new Language());

            return "language/languageadd";

        } else {

            status.setComplete();

            if (null != language){
                languageService.save(language);
            }
            return "redirect:/languages/list";
        }
    }

    @RequestMapping(value = "/delete/{locale}")
    public String delete(@PathVariable String locale) {
        languageService.delete(locale);
        return "redirect:/languages/list";
    }

    @RequestMapping(value = "/edit/{locale}")
    public String edit(@PathVariable String locale, Model model) {
        Language language = languageService.get(locale);
        model.addAttribute("language", language);
        return "language/languageedit";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@ModelAttribute Language language) {
        languageService.update(language);
        return "redirect:/languages/list";
    }
}