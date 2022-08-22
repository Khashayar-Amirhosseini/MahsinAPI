package com.MahSinApi.model.repository;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

@Repository
public class JpaRepsitory<T,I>{
    @PersistenceContext
    private EntityManager entityManager;

    public void persist(T t) {
        entityManager.persist(t);
    }

    public void delete(T t) {
        t = entityManager.merge(t);
        entityManager.remove(t);
    }

    public void update(T t) {
        entityManager.merge(t);
    }

    public T findOne(Class<T> tClass, I id) {
        return entityManager.find(tClass, id);
    }

    public List<T> findAll(Class<T> tClass) {
        CriteriaQuery criteriaQuery = entityManager.getCriteriaBuilder().createQuery(tClass);
        criteriaQuery.from(tClass);
        return entityManager.createQuery(criteriaQuery).getResultList();
    }
}
