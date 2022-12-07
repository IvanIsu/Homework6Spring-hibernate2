package com.isupov.service;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;


@Component
public class ServiceConnection {
    private SessionFactory sessionFactory;

    public ServiceConnection() {
        this.sessionFactory = new Configuration().configure()
                .buildSessionFactory();
    }

    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }
}
