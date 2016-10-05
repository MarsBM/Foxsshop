package web;

import domain.localization.Language;
import domain.user.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import service.Utils;
import service.interfaces.CrudService;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by Mars on 03.10.2016.
 */
@Controller
@RequestMapping(value = "/roles")
public class UserRoles {

    @Autowired
    private CrudService<UserRole> roleService;
    @Autowired
    private CrudService<Language> languageService;

    private Integer resultsOnPage = 25;
    private String sortBy = "nameAsc";

    @RequestMapping(value = "/list")
    public String list(@RequestParam(required = false) String query,
                       @RequestParam(required = false) Integer number,
                       @RequestParam(required = false) Integer page,
                       @RequestParam(required = false) String sort,
                       @RequestParam(required = false) String added,
                       @RequestParam(required = false) String updated,
                       @RequestParam(required = false) String deleted,
                       Model model, Locale locale) {

        //Збереження кількості рядків для відображення
        if (!(null == number || 0 == number)) resultsOnPage = number;
        if (null != sort) sortBy = sort;
        if (null == added) added = "";
        if (null == updated) updated = "";
        if (null == deleted) deleted = "";
        if (null == page || 0 == page) page = 1;
        if (null == query) query = "";

        //Сортування результату
        String by = "name";
        boolean method = false;
        switch (sortBy) {
            case "nameAsc":
                by = "name";
                method = false;
                break;
            case "nameDesc":
                by = "name";
                method = true;
                break;
        }

        query = Utils.searchQuery(query);
        int first = Utils.firstResultToPage(resultsOnPage, page);
        List<UserRole> userRoles = roleService.list(first, resultsOnPage, query, by, method);

        if (added.equals("true")) model.addAttribute("success", "role.success.added.new");
        if (updated.equals("true")) model.addAttribute("success", "role.success.updated");
        if (deleted.equals("true")) model.addAttribute("success", "role.success.deleted");
        if (deleted.equals("false")) model.addAttribute("error", "role.err.deleted");
        model.addAttribute("sortBy", sortBy);
        model.addAttribute("userRoles",userRoles);
        model.addAttribute("resultsOnPage", resultsOnPage);
        model.addAttribute("pages", Utils.pagination(roleService.count(query), resultsOnPage));
        model.addAttribute("currentPage", page);
        model.addAttribute("languages", languageService.list());
        model.addAttribute("locale", locale.getLanguage());
        model.addAttribute("activeLang", languageService.get(locale.getLanguage()).getName());
        return "userRole/list";
    }

    @RequestMapping(value = "/delete")
    public String delete(@RequestParam Integer id) {
        if (!roleService.get(id).getUsers().isEmpty()) {
            return "redirect:/roles/list?deleted=false";
        } else {
            roleService.delete(id);
            return "redirect:/roles/list?deleted=true";
        }
    }

    @RequestMapping(value = "/edit")
    public String edit(@RequestParam(required = false) Integer id, Model model) {
        UserRole userRole;
        if (id == null) {
            userRole = new UserRole();
        } else {
            userRole = roleService.get(id);
        }
        model.addAttribute("role", userRole);
        return "userRole/edit";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@ModelAttribute @Valid UserRole userRole,
                       BindingResult result,
                       Model model) {
        if (result.hasErrors()) {
            model.addAttribute("role", userRole);
            model.addAttribute("error", "error.field");
            return "userRole/edit";
        } else {
            if (null != userRole){
                if (userRole.getId() == null) {
                    roleService.save(userRole);
                    return "redirect:/roles/list?added=true";
                } else {
                    roleService.update(userRole);
                    return "redirect:/roles/list?updated=true";
                }
            }
            return "redirect:/roles/list";
        }
    }
}
