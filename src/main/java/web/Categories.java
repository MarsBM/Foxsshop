package web;

import domain.category.Category;
import domain.category.CategoryDescription;
import domain.localization.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MultipartFile;
import service.Utils;
import service.interfaces.CrudService;

import javax.validation.Valid;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.*;

/**
 * Created by Mars on 23.08.2016.
 */
@Controller
@RequestMapping(value = "/categories")
public class Categories {

    @Autowired
    private CrudService<Category> categoryService;
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
        boolean method = false;
        switch (sortBy) {
            case "nameAsc":
                method = false;
                break;
            case "nameDesc":
                method = true;
                break;
        }

        query = Utils.searchQuery(query);
        int first = Utils.firstResultToPage(resultsOnPage, page);
        List<Category> categories = categoryService.list(first, resultsOnPage, query, null, method);

        if (added.equals("true")) model.addAttribute("success", "category.success.added.new");
        if (updated.equals("true")) model.addAttribute("success", "category.success.updated");
        if (deleted.equals("true")) model.addAttribute("success", "category.success.deleted");
        if (deleted.equals("false")) model.addAttribute("error", "category.err.deleted");
        model.addAttribute("sortBy", sortBy);
        model.addAttribute("categories",categories);
        model.addAttribute("resultsOnPage", resultsOnPage);
        model.addAttribute("pages", Utils.pagination(categoryService.count(query), resultsOnPage));
        model.addAttribute("currentPage", page);
        model.addAttribute("languages", languageService.list());
        model.addAttribute("locale", locale.getLanguage());
        model.addAttribute("activeLang", languageService.get(locale.getLanguage()).getName());
        return "category/list";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@ModelAttribute @Valid Category category,
                      BindingResult result,
                      Model model) {
        if (result.hasErrors()) {
            List<Language> languages = languageService.list();
            model.addAttribute("category", category);
            model.addAttribute("languages", languages);
            model.addAttribute("error", "error.field");
            return "category/edit";
        } else {
            if (null != category){
                if (category.getId() == null) {
                    categoryService.save(category);
                    return "redirect:/categories/list?added=true";
                } else {
                    categoryService.update(category);
                    return "redirect:/categories/list?updated=true";
                }
            }
            return "redirect:/categories/list";
        }
    }

    @RequestMapping(value = "/delete")
    public String delete(@RequestParam Integer id) {
        Category category = categoryService.get(id);
        if (!category.getProducts().isEmpty()) return "redirect:/categories/list?deleted=false";
        categoryService.delete(id);
        return "redirect:/categories/list?deleted=true";
    }

    @RequestMapping(value = "/edit")
    public String edit(@RequestParam(required = false) Integer id, Model model) {
        List<Language> languages = languageService.list();
        Category category;
        List<CategoryDescription> descriptions;
        if (id == null) {
            category = new Category();
            descriptions = new ArrayList<>();
            category.setDescriptions(descriptions);
        } else {
            category = categoryService.get(id);
            descriptions = category.getDescriptions();
        }
        //Якщо в категорії в описах немає всім мов, то це створить відповідні записи в базу даних
        if (descriptions.size() < languages.size()) {
            for (Language l : languages) {
                boolean contains = false;
                for (CategoryDescription d : descriptions) {
                    if (d.getLanguage().equals(l)) {
                        contains = true;
                        break;
                    }
                }
                if (!contains) descriptions.add(new CategoryDescription(l, "", ""));
            }
        }
        model.addAttribute("category", category);
        model.addAttribute("languages", languages);
        return "category/edit";
    }
}