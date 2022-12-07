package com.isupov.model.dao.daoimpl;


import com.isupov.model.Product;
import com.isupov.model.dao.ProductDao;
import com.isupov.service.ServiceConnection;
import org.hibernate.Session;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class ProductDaoImpl implements ProductDao {
    private ServiceConnection serviceConnection;

    public ProductDaoImpl(ServiceConnection serviceConnection) {
        this.serviceConnection = serviceConnection;
    }

    @Override
    public Product findById(Long id) {
        Session session = serviceConnection.getSession();
        session.beginTransaction();
        Product product = session.get(Product.class, id);
        session.getTransaction().commit();
        return product;
    }

    @Override
    public List<Product> findAll() {
        Session session = serviceConnection.getSession();
        session.beginTransaction();
        List<Product> productList = session.createQuery("from Product").getResultList();
        session.getTransaction().commit();
        return productList;
    }

    @Override
    public void deleteById(Long id) {
        Session session = serviceConnection.getSession();
        session.beginTransaction();
        session.delete(id);
        session.getTransaction().commit();
    }



}

