package com.isupov.model.dao.daoimpl;

import com.isupov.model.Order;
import com.isupov.model.Product;
import com.isupov.model.User;
import com.isupov.model.dao.UserDao;
import com.isupov.service.ServiceConnection;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserDaoImpl implements UserDao {
    private ServiceConnection serviceConnection;

    public UserDaoImpl(ServiceConnection serviceConnection) {
        this.serviceConnection = serviceConnection;
    }

    @Override
    public User findById(Long id) {
        Session session =  serviceConnection.getSession();
        session.beginTransaction();
        User user = session.get(User.class, id);
        session.getTransaction().commit();
        return user;
    }

}
