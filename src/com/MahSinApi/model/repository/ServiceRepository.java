package com.MahSinApi.model.repository;

import com.MahSinApi.model.entity.MainService;
import com.MahSinApi.model.entity.Service;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Repository
public class ServiceRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public MainService findMainService(Service service){

        Query query=entityManager.createQuery("select distinct o from MAIN_SERVICES o where o.service=:nid ");
        query.setParameter("nid",service);
        return (MainService) query.getResultList();
    }
}
