package com.MahSinApi.model.service;


import com.MahSinApi.model.entity.ParagraphPic;
import com.MahSinApi.model.repository.JpaRepsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ParagraphPicService {
    @Autowired
    private JpaRepsitory<ParagraphPic,Long> jpaRepository;
    @Transactional
    public void save(ParagraphPic paragraphPic){
        jpaRepository.persist(paragraphPic);
    }
    @Transactional
    public void update(ParagraphPic paragraphPic) {
        jpaRepository.update(paragraphPic);
    }
    @Transactional
    public void delete(ParagraphPic paragraphPic){
        jpaRepository.delete(paragraphPic);
    }
    public ParagraphPic findOne(long id){
        return   jpaRepository.findOne(ParagraphPic.class,id);
    }
    public List<ParagraphPic> findAll(){
        return jpaRepository.findAll(ParagraphPic.class);
    }
}
