package dao;

import dao.interfaces.CrudDAO;
import domain.product.Review;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Mars on 20.10.2016.
 */
@Repository
public class ReviewDAOImpl implements CrudDAO<Review> {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Review> list() {
        return null;
    }

    @Override
    public List<Review> list(int firstResult, int maxResults) {
        return null;
    }

    @Override
    public List<Review> list(String searchString) {
        return null;
    }

    @Override
    public List<Review> list(int firstResult, int maxResults, String searchString) {
        return null;
    }

    @Override
    public List<Review> list(String sortBy, boolean desc) {
        return null;
    }

    @Override
    public List<Review> list(int firstResult, int maxResults, String sortBy, boolean desc) {
        return null;
    }

    @Override
    public List<Review> list(String searchString, String sortBy, boolean desc) {
        return null;
    }

    @Override
    public List<Review> list(int firstResult, int maxResults, String searchString, String sortBy, boolean desc) {
        return null;
    }

    @Override
    public Review get(Object o) {
        return null;
    }

    @Override
    public void delete(Object o) {

    }

    @Override
    public void save(Review review) {

    }

    @Override
    public void update(Review review) {

    }

    @Override
    public Long count() {
        return null;
    }

    @Override
    public Long count(String searchString) {
        return null;
    }
}
