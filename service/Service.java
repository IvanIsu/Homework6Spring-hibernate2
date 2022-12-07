package com.isupov.service;

import com.isupov.model.*;
import com.isupov.model.dao.daoimpl.OrderDaoImpl;
import com.isupov.model.dao.daoimpl.ProductDaoImpl;
import com.isupov.model.dao.daoimpl.UserDaoImpl;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Service {
    private ProductDaoImpl productDao;
    private UserDaoImpl userDao;
    private OrderDaoImpl orderDao;


    public Service(ProductDaoImpl productDao, UserDaoImpl userDao, OrderDaoImpl orderDao) {
        this.productDao = productDao;
        this.userDao = userDao;
        this.orderDao = orderDao;
    }


    public Order userBuyProduct(long id_user, long id_product) {
        User user = userDao.findById(id_user);
        Product product = productDao.findById(id_product);
        Order order = new Order(product.getCost(), user, product);
        orderDao.saveOrder(order);
        return order;
    }

    public List<Product> getAllProduct() {
        return productDao.findAll();
    }

    public List<Order> getOrder(Long user_id, Long product_id) {
        return orderDao.getOrder(user_id, product_id);
    }

    public List<Product> getProductsByUserId(Long id) {
        return orderDao.getAllProductByUserId(id);
    }

    public List<User> getUsersByProductId(Long id) {
        return orderDao.getAllUserByProductId(id);
    }


}
