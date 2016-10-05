package service;

import dao.interfaces.CrudDAO;
import domain.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.interfaces.CrudService;

import java.util.List;

/**
 * Created by Mars on 04.10.2016.
 */
@Service("productService")
@Transactional
public class ProductServiceImpl implements CrudService<Product> {

    @Autowired
    private CrudDAO<Product> crudDAO;

    @Override
    public List<Product> list() {
        return null;
    }

    @Override
    public List<Product> list(int firstResult, int maxResults) {
        return null;
    }

    @Override
    public List<Product> list(String searchString) {
        return null;
    }

    @Override
    public List<Product> list(int firstResult, int maxResults, String searchString) {
        return null;
    }

    @Override
    public List<Product> list(String sortBy, boolean desc) {
        return null;
    }

    @Override
    public List<Product> list(int firstResult, int maxResults, String sortBy, boolean desc) {
        return null;
    }

    @Override
    public List<Product> list(String searchString, String sortBy, boolean desc) {
        return null;
    }

    @Override
    public List<Product> list(int firstResult, int maxResults, String searchString, String sortBy, boolean desc) {
        return crudDAO.list(firstResult, maxResults, searchString, sortBy, desc);
    }

    @Override
    public Product get(Object o) {
        return null;
    }

    @Override
    public void delete(Object o) {

    }

    @Override
    public void save(Product product) {

    }

    @Override
    public void update(Product product) {

    }

    @Override
    public Long count() {
        return null;
    }

    @Override
    public Long count(String searchString) {
        return crudDAO.count(searchString);
    }
}
