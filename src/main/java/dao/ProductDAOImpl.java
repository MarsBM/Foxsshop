package dao;

import dao.interfaces.CrudDAO;
import domain.product.Product;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Mars on 04.10.2016.
 */
@Repository
public class ProductDAOImpl implements CrudDAO<Product> {

    @Autowired
    private SessionFactory sessionFactory;

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

    @SuppressWarnings("unchecked")
    @Override
    public List<Product> list(int firstResult, int maxResults, String searchString, String sortBy, boolean desc) {
        return sessionFactory.getCurrentSession()
                .createQuery("select distinct p from Product p inner join p.descriptions pd where pd.name like :searchString" + " order by pd.name" + (desc ? " desc" : " "))
                .setParameter("searchString", "%" + searchString + "%")
                .setFirstResult(firstResult)
                .setMaxResults(maxResults)
                .list();
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
        return (Long) sessionFactory.getCurrentSession()
                .createQuery("select count(distinct p) from Product p inner join p.descriptions pd where pd.name like :searchString")
                .setParameter("searchString", "%" + searchString + "%")
                .iterate().next();
    }
}
