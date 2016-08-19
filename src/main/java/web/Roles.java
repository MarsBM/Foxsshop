package web;

import domain.user.UserRole;
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
import java.sql.Date;

/**
 * Created by Mars on 19.08.2016.
 */
@Controller
@RequestMapping(value = "/roles")
public class Roles {

    @Autowired
    CrudService<UserRole> roleService;

    @RequestMapping(value = "/list")
    public String list(Model model) {
        model.addAttribute("roles", roleService.list());
        return "userRole/roleslist";
    }

    @RequestMapping(value = "/new")
    public String addUser(Model model) {
        model.addAttribute("role", new UserRole());
        return "userRole/roleadd";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@ModelAttribute @Valid UserRole userRole, BindingResult result, SessionStatus status, Model model) {

        if (result.hasErrors()) {

            model.addAttribute("role", new UserRole());

            return "userRole/roleadd";

        } else {

            status.setComplete();

            if (null != userRole){
                roleService.saveOrUpdate(userRole);
            }
            return "redirect:/roles/list";
        }
    }

    @RequestMapping(value = "/delete/{id}")
    public String delete(@PathVariable Integer id) {
        roleService.delete(id);
        return "redirect:/roles/list";
    }

    @RequestMapping(value = "/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        UserRole userRole = roleService.get(id);
        model.addAttribute("role", userRole);
        return "userRole/roleedit";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@ModelAttribute UserRole userRole) {
        roleService.saveOrUpdate(userRole);
        return "redirect:/roles/list";
    }
}
