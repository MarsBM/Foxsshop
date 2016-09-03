package web;

import domain.category.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import service.interfaces.CrudService;
import service.sorting.CategorySort;

import javax.validation.Valid;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;

/**
 * Created by Mars on 23.08.2016.
 */
@Controller
@RequestMapping(value = "/categories")
public class Categories {

    @Autowired
    private CrudService<Category> categoryService;

    @RequestMapping(value = "/list")
    public String list(Model model, Locale locale) {
        model.addAttribute("categories", CategorySort.sortForNameUk(categoryService.list(), categoryService));
        return "category/list";
    }

    @RequestMapping(value = "/new")
    public String addNew(Model model, Locale locale) {
        model.addAttribute("category", new Category());
        model.addAttribute("categories", CategorySort.sortForNameUk(categoryService.list(), categoryService));
        return "category/add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@ModelAttribute @Valid Category category, BindingResult result, SessionStatus status, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("category", category);
            model.addAttribute("categories", CategorySort.sortForNameUk(categoryService.list(), categoryService));
            return "category/add";
        } else {
            status.setComplete();
            if (null != category){
                categoryService.save(category);
            }
            return "redirect:/categories/list";
        }
    }

    @RequestMapping(value = "/delete/{id}")
    public String delete(@PathVariable Long id, Model model) {
        List<Category> categories = categoryService.list();
        for (Category category : categories) {
            if (category.getParentCategoryId() == id) {
                model.addAttribute("category", new Category());
                model.addAttribute("categories", CategorySort.sortForNameUk(categoryService.list(), categoryService));
                model.addAttribute("error", "category.can.not.delete");
                return "category/list";
            }
        }
        categoryService.delete(id);
        return "redirect:/categories/list";
    }

    @RequestMapping(value = "/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        Category category = categoryService.get(id);
        List<Category> categories = categoryService.list();
        categories.remove(category);
        for (int i = 0; i < categories.size(); ) {
            Long parent = categories.get(i).getParentCategoryId();
            int saveSize = categories.size();
            while (parent != 0) {
                if (category.getId() == parent){
                    categories.remove(i);
                }
                Category tmp = categoryService.get(parent);
                parent = tmp.getParentCategoryId();
            }
            if (saveSize == categories.size()) i++;
        }
        model.addAttribute("category", category);
        model.addAttribute("categories", CategorySort.sortForNameUk(categories, categoryService));
        return "category/edit";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@ModelAttribute Category category) {
        categoryService.update(category);
        return "redirect:/categories/list";
    }

}