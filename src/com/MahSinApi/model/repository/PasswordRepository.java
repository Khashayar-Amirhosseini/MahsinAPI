package com.MahSinApi.model.repository;

import com.MahSinApi.model.entity.User;
import com.MahSinApi.model.entity.UserPassword;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Repository
public class PasswordRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public UserPassword findPasswordByUser(User user){
        Query query=entityManager.createQuery("select o from USER_PASSWORD o where o.user=:nid");
        query.setParameter("nid",user);
        return (UserPassword) query.getSingleResult();
    }
    public UserPassword findByKey(String key){
        Query query=entityManager.createQuery("select o from USER_PASSWORD o where o.securityKey=:nid");
        query.setParameter("nid",key);
        return (UserPassword) query.getSingleResult();
    }
}
