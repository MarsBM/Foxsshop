package service.sorting;

import domain.category.Category;
import org.springframework.beans.factory.annotation.Autowired;
import service.interfaces.CrudService;

import java.util.List;

/**
 * Created by Mars on 29.08.2016.
 */
public class CategorySort {

    private CategorySort() {
    }

    public static List<Category> sortForNameUk(List<Category> categories, CrudService<Category> categoryService) {
        for (Category category : categories) {
            String name = category.getNameUk();
            Long parentId = category.getParentCategoryId();
            while (parentId != 0) {
                Category parent = categoryService.get(parentId);
                parentId = parent.getParentCategoryId();
                name = parent.getNameUk() + " - " + name;
            }
            category.setNameUk(name);
        }
        /*categories.sort((o1, o2) -> o1.getNameUk().compareToIgnoreCase(o2.getNameUk()));*/
        return categories;
    }
}
