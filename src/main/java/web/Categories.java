package web;

import domain.category.Category;
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



    private Integer resultsOnPage = 25;
    private String sortBy = "nameUkAsc";
    private final static String IMG_UPLOAD_FOLDER_ROOT = "D:/Programing/shop/Foxsshop/src/main/webapp";
    private final static String SUFFIX_IMAGE_PATH = "/img/categories";

    @RequestMapping(value = "/list")
    public String list(@RequestParam(required = false) String query,
                       @RequestParam(required = false) Integer number,
                       @RequestParam(required = false) Integer page,
                       @RequestParam(required = false) String sort,
                       @RequestParam(required = false) Boolean success,
                       Model model, WebRequest webRequest) {

        //Збереження кількості рядків для відображення
        if (null == number || 0 == number) number = resultsOnPage;
        resultsOnPage = number;

        if (null == sort) sort = sortBy;
        sortBy = sort;

        if (null == success) success = false;
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
        List<Category> categories = categoryService.list(first, resultsOnPage, query, field, method);

        //Розрахунок кількості сторінок
        long listSize = categoryService.count(query);
        long pages = 0;
        if (listSize / resultsOnPage > 0) {
            pages = listSize / resultsOnPage;
            if (listSize % resultsOnPage != 0) pages++;
        }

        if (success) model.addAttribute("success", "category.success.added.new");
        model.addAttribute("sortBy", sortBy);
        model.addAttribute("categories",categories);
        model.addAttribute("resultsOnPage", resultsOnPage);
        model.addAttribute("pages", pages);
        model.addAttribute("currentPage", page);





        return "category/list";
    }

    @RequestMapping(value = "/new")
    public String addNew(Model model, Locale locale) {
        model.addAttribute("category", new Category());
        return "category/add";
    }

    @SuppressWarnings("Duplicates")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@ModelAttribute @Valid Category category,
                      @RequestParam(value = "file", required = false) MultipartFile file,
                      BindingResult result,
                      SessionStatus status,
                      Model model) {
        if (result.hasErrors()) {
            model.addAttribute("category", category);
            return "category/add";
        } else {
            status.setComplete();
            if (null != category){
                if (!file.isEmpty()) {
                    try {
                        byte[] bytes = file.getBytes();
                        String name = file.getOriginalFilename();
                        String rootPath = IMG_UPLOAD_FOLDER_ROOT + SUFFIX_IMAGE_PATH;
                        File dir = new File(rootPath);

                        if (!dir.exists()) {
                            dir.mkdirs();
                        }

                        File uploadedFile = new File(dir.getAbsolutePath() + File.separator + name);

                        if (!uploadedFile.exists()) {
                            BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(uploadedFile));
                            stream.write(bytes);
                            stream.flush();
                            stream.close();
                        }

                        category.setImageFilePath(SUFFIX_IMAGE_PATH + File.separator + name);
                    } catch (Exception e) {
                        model.addAttribute("category", category);
                        model.addAttribute("error", "category.loadfile.error");
                        return "category/add";
                    }
                }
                categoryService.save(category);
            }
            return "redirect:/categories/list?success=true";
        }
    }

    @RequestMapping(value = "/delete/{id}")
    public String delete(@PathVariable Long id, Model model) {
        categoryService.delete(id);
        return "redirect:/categories/list";
    }

    @RequestMapping(value = "/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        Category category = categoryService.get(id);

        model.addAttribute("category", category);
        return "category/edit";
    }

    @SuppressWarnings("Duplicates")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@ModelAttribute Category category,
                         @RequestParam(value = "file", required = false) MultipartFile file,
                         Model model) {



        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();
                String name = file.getOriginalFilename();
                String rootPath = IMG_UPLOAD_FOLDER_ROOT + SUFFIX_IMAGE_PATH;
                File dir = new File(rootPath);

                if (!dir.exists()) {
                    dir.mkdirs();
                }

                File uploadedFile = new File(dir.getAbsolutePath() + File.separator + name);

                if (!uploadedFile.exists()) {
                    BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(uploadedFile));
                    stream.write(bytes);
                    stream.flush();
                    stream.close();
                }

                category.setImageFilePath(SUFFIX_IMAGE_PATH + File.separator + name);
            } catch (Exception e) {
                model.addAttribute("category", category);
                model.addAttribute("error", "category.loadfile.error");
                return "category/edit";
            }
        }
        categoryService.update(category);
        return "redirect:/categories/list?success=true";
    }

    @RequestMapping(value = "/test", method = RequestMethod.POST)
    public @ResponseBody Category test() {
        Category category = new Category();
        category.setNameUk("test name");
        return category;
    }

}