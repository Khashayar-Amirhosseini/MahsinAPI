package com.MahSinApi.model.service;

import com.MahSinApi.model.entity.Picture;
import com.MahSinApi.model.entity.Policy;
import com.MahSinApi.model.repository.JpaRepsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PictureService {
    @Autowired
    private JpaRepsitory<Picture,Long> jpaRepository;
    @Transactional
    public void save(Picture picture){
        jpaRepository.persist(picture);
    }
    @Transactional
    public void update(Picture picture) {
        jpaRepository.update(picture);
    }
    @Transactional
    public void delete(Picture picture){
        jpaRepository.delete(picture);
    }
    public Picture findOne(long id){
        return   jpaRepository.findOne(Picture.class,id);
    }
    public List<Picture> findAll(){
        return jpaRepository.findAll(Picture.class);
    }
}
