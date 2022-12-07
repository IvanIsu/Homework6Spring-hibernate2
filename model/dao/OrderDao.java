package com.isupov.model.dao;

import com.isupov.model.Order;
import com.isupov.model.Product;
import com.isupov.model.User;

import java.util.List;

public interface OrderDao {
    Order saveOrder(Order order);


    List<User> getAllUserByProductId(Long id);

    List<Product> getAllProductByUserId(Long id);


    List<Order> getOrder(Long id_user, Long id_product);
}
