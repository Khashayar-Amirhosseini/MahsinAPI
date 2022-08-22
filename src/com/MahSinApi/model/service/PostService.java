package com.MahSinApi.model.service;
import com.MahSinApi.model.entity.Post;
import com.MahSinApi.model.repository.JpaRepsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PostService {
    @Autowired
    private JpaRepsitory<Post,Long> jpaRepository;
    @Transactional
    public void save(Post post){
        jpaRepository.persist(post);
    }
    @Transactional
    public void update(Post post) {
        jpaRepository.update(post);
    }
    @Transactional
    public void delete(Post post){
        jpaRepository.delete(post);
    }
    public Post findOne(long id){
        return   jpaRepository.findOne(Post.class,id);
    }
    public List<Post> findAll(){
        return jpaRepository.findAll(Post.class);
    }
}
