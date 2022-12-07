package com.isupov.model.dao.daoimpl;

import com.isupov.model.Order;
import com.isupov.model.Product;
import com.isupov.model.User;
import com.isupov.model.dao.OrderDao;
import com.isupov.service.ServiceConnection;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderDaoImpl implements OrderDao {

    private ServiceConnection serviceConnection;

    public OrderDaoImpl(ServiceConnection serviceConnection) {
        this.serviceConnection = serviceConnection;
    }

    @Override
    public Order saveOrder(Order order) {
        Session session = serviceConnection.getSession();
        session.beginTransaction();
        session.save(order);
        session.getTransaction().commit();
        return order;
    }

    @Override
    public List<Product> getAllProductByUserId(Long id) {
        Session session = serviceConnection.getSession();
        session.beginTransaction();
        Query query = session.createQuery("select o from Order o WHERE user.id = :id");
        query.setParameter("id", id);
        List<Order> orderList = query.getResultList();
        List<Product> productList = new ArrayList<>();
        for (Order o : orderList) {
            productList.add(o.getProduct());
        }
        session.getTransaction().commit();
        return productList;
    }

    @Override
    public List<User> getAllUserByProductId(Long id) {
        Session session = serviceConnection.getSession();
        session.beginTransaction();
        Query query = session.createQuery("select o from Order o WHERE product.id =: id");
        query.setParameter("id", id);
        List<Order> orderList = query.getResultList();
        List<User> userList = new ArrayList<>();
        for (Order o : orderList) {
            userList.add(o.getUser());
        }
        session.getTransaction().commit();
        return userList;
    }

    @Override
    public List<Order> getOrder(Long id_user, Long id_product) {
        Session session = serviceConnection.getSession();
        session.beginTransaction();
        Query query = session.createQuery("select o from Order o WHERE user.id =: id_user AND product.id =: id_product");
        query.setParameter("id_user", id_user);
        query.setParameter("id_product", id_product);
        List<Order> orderList = query.getResultList();

        session.getTransaction().commit();
        return orderList;
    }
}
