package com.MahSinApi.model.service;

import com.MahSinApi.model.entity.Goal;
import com.MahSinApi.model.entity.MainService;
import com.MahSinApi.model.repository.JpaRepsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MainServiceService {
    @Autowired
    private JpaRepsitory<MainService,Long> jpaRepository;
    @Transactional
    public void save(MainService mainService){
        jpaRepository.persist(mainService);
    }
    @Transactional
    public void update(MainService mainService) {
        jpaRepository.update(mainService);
    }
    @Transactional
    public void delete(MainService mainService){
        jpaRepository.delete(mainService);
    }
    public MainService findOne(long id){
        return   jpaRepository.findOne(MainService.class,id);
    }
    public List<MainService> findAll(){
        return jpaRepository.findAll(MainService.class);
    }
}
