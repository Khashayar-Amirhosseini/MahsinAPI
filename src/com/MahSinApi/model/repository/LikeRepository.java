package com.MahSinApi.model.repository;

import com.MahSinApi.model.entity.Doctor;
import com.MahSinApi.model.entity.Like;
import com.MahSinApi.model.entity.Post;
import com.MahSinApi.model.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class LikeRepository {
    @PersistenceContext
    private EntityManager entityManager;
public Like findLikeByUserAndDoctor(User user, Doctor doctor){
    Query query=entityManager.createQuery("select o from LIKES o where o.user=:nid and o.doctor=:mid");
    query.setParameter("nid",user);
    query.setParameter("mid",doctor);
    Like like=(Like) query.getSingleResult();
    return like;
}

public long findCountOfActionByDoctor(Doctor doctor,
                                    String action){

    Query query=entityManager.createQuery("select distinct o from LIKES o where o.doctor=:mid and o.action=:nid");
    query.setParameter("mid",doctor);
    query.setParameter("nid",action);
    List<Like> likes= query.getResultList();
    long countOfAction=likes.size();
    return countOfAction;
}
    public Like findLikeByUserAndPost(User user, Post post){
        Query query=entityManager.createQuery("select o from LIKES o where o.user=:nid and o.post=:mid");
        query.setParameter("nid",user);
        query.setParameter("mid",post);
        Like like=(Like) query.getSingleResult();
        return like;
    }

    public long findCountOfActionByPost(Post post,
                                          String action){
        Query query=entityManager.createQuery("select distinct o from LIKES o where o.post=:mid and o.action=:nid");
        query.setParameter("mid",post);
        query.setParameter("nid",action);
        List<Like> likes= query.getResultList();
        long countOfAction=likes.size();
        return countOfAction;
    }



}
