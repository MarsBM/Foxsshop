package web;

import domain.localization.Language;
import domain.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.Utils;
import service.interfaces.CrudService;

import java.util.List;
import java.util.Locale;

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
}
