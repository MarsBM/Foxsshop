package service;

import dao.interfaces.CrudDAO;
import domain.product.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.interfaces.CrudService;

import java.util.List;

/**
 * Created by Mars on 20.10.2016.
 */
@Service("reviewService")
@Transactional
public class ReviewServiceImpl implements CrudService<Review> {

    @Autowired
    private CrudDAO<Review> crudDAO;

    @Override
    public List<Review> list() {
        return crudDAO.list();
    }

    @Override
    public List<Review> list(int firstResult, int maxResults) {
        return crudDAO.list(firstResult, maxResults);
    }

    @Override
    public List<Review> list(String searchString) {
        return crudDAO.list(searchString);
    }

    @Override
    public List<Review> list(int firstResult, int maxResults, String searchString) {
        return crudDAO.list(firstResult, maxResults, searchString);
    }

    @Override
    public List<Review> list(String sortBy, boolean desc) {
        return crudDAO.list(sortBy, desc);
    }

    @Override
    public List<Review> list(int firstResult, int maxResults, String sortBy, boolean desc) {
        return crudDAO.list(firstResult, maxResults, sortBy, desc);
    }

    @Override
    public List<Review> list(String searchString, String sortBy, boolean desc) {
        return crudDAO.list(searchString, sortBy, desc);
    }

    @Override
    public List<Review> list(int firstResult, int maxResults, String searchString, String sortBy, boolean desc) {
        return crudDAO.list(firstResult, maxResults, searchString, sortBy, desc);
    }

    @Override
    public Review get(Object o) {
        return crudDAO.get(o);
    }

    @Override
    public void delete(Object o) {
        crudDAO.delete(o);
    }

    @Override
    public void save(Review review) {
        crudDAO.save(review);
    }

    @Override
    public void update(Review review) {
        crudDAO.update(review);
    }

    @Override
    public Long count() {
        return crudDAO.count();
    }

    @Override
    public Long count(String searchString) {
        return crudDAO.count(searchString);
    }
}
