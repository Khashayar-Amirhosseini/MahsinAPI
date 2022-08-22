package com.MahSinApi.model.service;

import com.MahSinApi.model.entity.Reference;
import com.MahSinApi.model.repository.JpaRepsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ReferenceService {
    @Autowired
    private JpaRepsitory<Reference,Long> jpaRepository;
    @Transactional
    public void save(Reference reference){
        jpaRepository.persist(reference);
    }
    @Transactional
    public void update(Reference reference) {
        jpaRepository.update(reference);
    }
    @Transactional
    public void delete(Reference reference){
        jpaRepository.delete(reference);
    }
    public Reference findOne(long id){
        return   jpaRepository.findOne(Reference.class,id);
    }
    public List<Reference> findAll(){
        return jpaRepository.findAll(Reference.class);
    }
}
