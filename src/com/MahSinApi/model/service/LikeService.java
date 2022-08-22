package com.MahSinApi.model.service;

import com.MahSinApi.model.entity.Doctor;
import com.MahSinApi.model.entity.Like;
import com.MahSinApi.model.entity.Post;
import com.MahSinApi.model.entity.User;
import com.MahSinApi.model.repository.JpaRepsitory;
import com.MahSinApi.model.repository.LikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LikeService {
    @Autowired
    private JpaRepsitory<Like,Long> jpaRepository;
    @Autowired
    private LikeRepository likeRepository;


    @Transactional
    public void save(Like like){
        jpaRepository.persist(like);
    }
    @Transactional
    public void update(Like like) {
        jpaRepository.update(like);
    }
    @Transactional
    public void delete(Like like){
        jpaRepository.delete(like);
    }
    public Like findOne(long id){
        return   jpaRepository.findOne(Like.class,id);
    }
    public List<Like> findAll(){
        return jpaRepository.findAll(Like.class);
    }
    public Like findByUserAndDoctor(User user,Doctor doctor){
        return likeRepository.findLikeByUserAndDoctor(user,doctor);
    }
    public long findCountOfActionByDoctor(Doctor doctor,String action){
        return likeRepository.findCountOfActionByDoctor(doctor,action);
    }
    public Like findByUserAndPost(User user, Post post){
        return likeRepository.findLikeByUserAndPost(user,post);
    }
    public long findCountOfActionByPost(Post post,String action){
        return likeRepository.findCountOfActionByPost(post,action);
    }
}
