package web;

import domain.category.Category;
import domain.localization.Language;
import domain.manufacturer.Manufacturer;
import domain.product.Attribute;
import domain.product.Product;
import domain.product.ProductDescription;
import domain.product.ProductOption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import service.Utils;
import service.interfaces.CrudService;

import javax.validation.Valid;
import java.util.*;

/**
 * Created by Mars on 04.10.2016.
 */
@Controller
@RequestMapping(value = "/products")
public class Products {

    @Autowired
    private CrudService<Product> productService;

    @Autowired
    private CrudService<Language> languageService;

    @Autowired
    private CrudService<Manufacturer> manufacturerService;

    @Autowired
    private CrudService<Category> categoryService;

    @Autowired
    private CrudService<Attribute> attributeService;

    private Integer resultsOnPage = 25;
    private String sortBy = "nameAsc";

    @SuppressWarnings("Duplicates")
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
        List<Product> products = productService.list(first, resultsOnPage, query, null, method);



        if (added.equals("true")) model.addAttribute("success", "product.success.added.new");
        if (updated.equals("true")) model.addAttribute("success", "product.success.updated");
        if (deleted.equals("true")) model.addAttribute("success", "product.success.deleted");
        if (deleted.equals("false")) model.addAttribute("success", "product.err.deleted");
        model.addAttribute("sortBy", sortBy);
        model.addAttribute("products", products);
        model.addAttribute("resultsOnPage", resultsOnPage);
        model.addAttribute("pages", Utils.pagination(productService.count(query), resultsOnPage));
        model.addAttribute("currentPage", page);
        model.addAttribute("languages", languageService.list());
        model.addAttribute("locale", locale.getLanguage());
        model.addAttribute("activeLang", languageService.get(locale.getLanguage()).getName());
        return "product/list";
    }

    @RequestMapping(value = "/delete")
    public String delete(@RequestParam Long id) {
        Product product = productService.get(id);
        if (product.getCartItems().isEmpty() && product.getOrderItems().isEmpty()) {
            productService.delete(id);
            return "redirect:/products/list?deleted=true";
        } else {
            return "redirect:/products/list?deleted=false";
        }
    }

    @RequestMapping(value = "/edit")
    public String edit(@RequestParam(required = false) Long id,
                       Model model, Locale locale) {
        List<Language> languages = languageService.list();
        Product product;
        List<ProductDescription> descriptions;
        List<ProductOption> options;
        List<Manufacturer> manufacturers = manufacturerService.list();
        if (id == null) {
            product = new Product();
            descriptions = new ArrayList<>();
            options = new ArrayList<>();
            product.setDescriptions(descriptions);
            product.setOptions(options);
        } else {
            product = productService.get(id);
            descriptions = product.getDescriptions();
        }
        //Якщо в категорії в описах немає всім мов, то це створить відповідні записи в базу даних
        if (descriptions.size() < languages.size()) {
            for (Language l : languages) {
                boolean contains = false;
                for (ProductDescription d : descriptions) {
                    if (d.getLanguage().equals(l)) {
                        contains = true;
                        break;
                    }
                }
                if (!contains) descriptions.add(new ProductDescription(l, "", ""));
            }
        }
        model.addAttribute("product", product);
        model.addAttribute("languages", languages);
        model.addAttribute("categories_list", categoryService.list());
        model.addAttribute("attributes_list", attributeService.list());
        model.addAttribute("locale", locale.getLanguage());
        model.addAttribute("manufacturers", manufacturers);
        return "product/edit";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@ModelAttribute @Valid Product product,
                       BindingResult result,
                       Model model, Locale locale) {
        if (result.hasErrors()) {
            List<Language> languages = languageService.list();
            List<Manufacturer> manufacturers = manufacturerService.list();
            model.addAttribute("product", product);
            model.addAttribute("languages", languages);
            model.addAttribute("categories_list", categoryService.list());
            model.addAttribute("attributes_list", attributeService.list());
            model.addAttribute("locale", locale.getLanguage());
            model.addAttribute("manufacturers", manufacturers);
            model.addAttribute("error", "error.field");
            return "product/edit";
        } else {
            if (null != product){
                if (!product.getCategories().isEmpty()) {
                    product.setCategories(new ArrayList<>(new HashSet<>(product.getCategories())));
                }
                product.setModifyDate(new Date());
                if (product.getId() == null) {
                    product.setCreateDate(new Date());
                    productService.save(product);
                    return "redirect:/products/list?added=true";
                } else {
                    productService.update(product);
                    return "redirect:/products/list?updated=true";
                }
            }
            return "redirect:/products/list";
        }
    }

}
