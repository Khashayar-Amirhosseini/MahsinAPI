package com.MahSinApi.model.service;

import com.MahSinApi.model.entity.KeyWords;
import com.MahSinApi.model.repository.JpaRepsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class KeywordService {
    @Autowired
    private JpaRepsitory<KeyWords,Long> jpaRepository;
    @Transactional
    public void save(KeyWords keyWords){
        jpaRepository.persist(keyWords);
    }
    @Transactional
    public void update(KeyWords keyWords) {
        jpaRepository.update(keyWords);
    }
    @Transactional
    public void delete(KeyWords keyWords){
        jpaRepository.delete(keyWords);
    }
    public KeyWords findOne(long id){
        return   jpaRepository.findOne(KeyWords.class,id);
    }
    public List<KeyWords> findAll(){
        return jpaRepository.findAll(KeyWords.class);
    }
}
