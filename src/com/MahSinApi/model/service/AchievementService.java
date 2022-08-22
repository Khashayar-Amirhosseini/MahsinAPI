package com.MahSinApi.model.service;

import com.MahSinApi.model.entity.Achievement;
import com.MahSinApi.model.entity.Doctor;
import com.MahSinApi.model.repository.JpaRepsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AchievementService {
    @Autowired
    private JpaRepsitory<Achievement,Long> jpaRepository;
    @Transactional
    public void save(Achievement achievement){
        jpaRepository.persist(achievement);
    }
    @Transactional
    public void update(Achievement achievement) {
        jpaRepository.update(achievement);
    }
    @Transactional
    public void delete(Achievement achievement){
        jpaRepository.delete(achievement);
    }
    public Achievement findOne(long id){
        return   jpaRepository.findOne(Achievement.class,id);
    }
    public List<Achievement> findAll(){
        return jpaRepository.findAll(Achievement.class);
    }
}
