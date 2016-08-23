package web;

import domain.category.Category;
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

/**
 * Created by Mars on 23.08.2016.
 */
@Controller
@RequestMapping(value = "/categories")
public class Categories {

    @Autowired
    CrudService<Category> categoryService;

    @RequestMapping(value = "/list")
    public String list(Model model) {
        model.addAttribute("categories", categoryService.list());
        return "category/categorieslist";
    }

    @RequestMapping(value = "/new")
    public String addUser(Model model) {
        model.addAttribute("category", new Category());
        return "category/categoryadd";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@ModelAttribute @Valid Category category, BindingResult result, SessionStatus status, Model model) {

        if (result.hasErrors()) {

            model.addAttribute("category", new Category());

            return "category/categoryadd";

        } else {

            status.setComplete();

            if (null != category){
                categoryService.save(category);
            }
            return "redirect:/categories/list";
        }
    }

    @RequestMapping(value = "/delete/{id}")
    public String delete(@PathVariable Long id) {
        categoryService.delete(id);
        return "redirect:/categories/list";
    }

    @RequestMapping(value = "/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        Category category = categoryService.get(id);
        model.addAttribute("category", category);
        return "category/categoryedit";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@ModelAttribute Category category) {
        categoryService.update(category);
        return "redirect:/categories/list";
    }
}
