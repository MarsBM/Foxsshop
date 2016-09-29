package web;

import domain.category.Category;
import domain.category.CategoryDescription;
import domain.localization.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MultipartFile;
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
    private String sortBy = "nameUkAsc";
    private final static String IMG_UPLOAD_FOLDER_ROOT = "D:/Programing/shop/Foxsshop/src/main/webapp";
    private final static String SUFFIX_IMAGE_PATH = "/img/categories";

    @RequestMapping(value = "/list")
    public String list(@RequestParam(required = false) String query,
                       @RequestParam(required = false) Integer number,
                       @RequestParam(required = false) Integer page,
                       @RequestParam(required = false) String sort,
                       @RequestParam(required = false) Boolean added,
                       @RequestParam(required = false) Boolean updated,
                       Model model, WebRequest webRequest) {

        //Збереження кількості рядків для відображення
        if (null == number || 0 == number) number = resultsOnPage;
        resultsOnPage = number;

        if (null == sort) sort = sortBy;
        sortBy = sort;

        if (null == added) added = false;
        if (null == updated) updated = false;
        if (null == page || 0 == page) page = 1;

        if (null == query) query = "";




        //Сортування результату
        String field = "nameUk";
        String method = "asc";
        switch (sortBy) {
            case "nameUkAsc":
                field = "nameUk";
                method = "asc";
                break;
            case "nameUkDesc":
                field = "nameUk";
                method = "desc";
                break;
        }

        query = query.replaceAll("(\\+)+", " ").toLowerCase();
        int first = resultsOnPage * (page - 1);

        //Завантаення списку
        List<Category> categories = categoryService.list(/*first, resultsOnPage, query, field, method*/);

        //Розрахунок кількості сторінок
        long listSize = categoryService.count(/*query*/);
        long pages = 0;
        if (listSize / resultsOnPage > 0) {
            pages = listSize / resultsOnPage;
            if (listSize % resultsOnPage != 0) pages++;
        }

        if (added) model.addAttribute("success", "category.success.added.new");
        if (updated) model.addAttribute("success", "category.success.updated");
        model.addAttribute("sortBy", sortBy);
        model.addAttribute("categories",categories);
        model.addAttribute("resultsOnPage", resultsOnPage);
        model.addAttribute("pages", pages);
        model.addAttribute("currentPage", page);

        return "category/list";
    }

    @RequestMapping(value = "/new")
    public String addNew(Model model, Locale locale) {

        {

        }


        Category category = new Category();
        List<Language> languages = languageService.list();
        List<CategoryDescription> descriptions = new ArrayList<>();

        for (Language l : languages) {
            descriptions.add(new CategoryDescription(l, "", ""));
        }
        category.setDescriptions(descriptions);
        model.addAttribute("category", category);
        model.addAttribute("languages", languages);
        return "category/add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@ModelAttribute @Valid Category category,
                      BindingResult result,
                      SessionStatus status,
                      Model model) {
        if (result.hasErrors()) {
            List<Language> languages = languageService.list();
            model.addAttribute("category", category);
            model.addAttribute("languages", languages);
            model.addAttribute("result", result.toString());
            return "category/add";
        } else {
            status.setComplete();
            if (null != category){
                categoryService.save(category);
            }
            return "redirect:/categories/list?added=true";
        }
    }

    @RequestMapping(value = "/delete/{id}")
    public String delete(@PathVariable Integer id) {
        categoryService.delete(id);
        return "redirect:/categories/list";
    }

    @RequestMapping(value = "/edit/{id}")
    public String edit(@PathVariable Integer id, Model model, WebRequest webRequest) {
        Category category = categoryService.get(id);
        List<Language> languages = languageService.list();
        List<CategoryDescription> descriptions = category.getDescriptions();

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

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@ModelAttribute Category category, Model model) {
        categoryService.update(category);
        return "redirect:/categories/list?updated=true";
    }

}