package com.MahSinApi.model.service;

import com.MahSinApi.model.entity.Achievement;
import com.MahSinApi.model.entity.Facility;
import com.MahSinApi.model.repository.JpaRepsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FacilityService {
    @Autowired
    private JpaRepsitory<Facility,Long> jpaRepository;
    @Transactional
    public void save(Facility facility){
        jpaRepository.persist(facility);
    }
    @Transactional
    public void update(Facility facility) {
        jpaRepository.update(facility);
    }
    @Transactional
    public void delete(Facility facility){
        jpaRepository.delete(facility);
    }
    public Facility findOne(long id){
        return   jpaRepository.findOne(Facility.class,id);
    }
    public List<Facility> findAll(){
        return jpaRepository.findAll(Facility.class);
    }
}
