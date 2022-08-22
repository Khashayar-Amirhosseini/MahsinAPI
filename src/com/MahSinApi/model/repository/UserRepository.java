package com.MahSinApi.model.repository;

import com.MahSinApi.model.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Repository
public class UserRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public User findUserByUserName(String userName){
        Query query=entityManager.createQuery("select o from MAHSIN_USER o where o.userName=:nid");
        query.setParameter("nid",userName);
        return (User) query.getSingleResult();
    }

}
