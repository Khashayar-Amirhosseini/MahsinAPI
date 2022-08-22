package com.MahSinApi.model.repository;

import com.MahSinApi.model.entity.Discount;
import com.MahSinApi.model.entity.Like;
import com.MahSinApi.model.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class DiscountRepository {
    @PersistenceContext
    private EntityManager entityManager;
    public List<Discount> getDiscountByUser(User customer){
        Query query=entityManager.createQuery("select o from DISCOUNTS o where o.customer=:nid ");
        query.setParameter("nid",customer);
        List<Discount> discounts=query.getResultList();
        return discounts;
    }
    public Discount getDiscountByCode(String code){
        Query query=entityManager.createQuery("select o from DISCOUNTS o where o.code=:nid ");
        query.setParameter("nid",code);
        return (Discount) query.getSingleResult();
    }

}
