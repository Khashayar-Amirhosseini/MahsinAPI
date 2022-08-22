package com.MahSinApi.model.service;

import com.MahSinApi.model.entity.Goal;
import com.MahSinApi.model.entity.Policy;
import com.MahSinApi.model.repository.JpaRepsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GoalService {
    @Autowired
    private JpaRepsitory<Goal,Long> jpaRepository;
    @Transactional
    public void save(Goal goal){
        jpaRepository.persist(goal);
    }
    @Transactional
    public void update(Goal goal) {
        jpaRepository.update(goal);
    }
    @Transactional
    public void delete(Goal goal){
        jpaRepository.delete(goal);
    }
    public Goal findOne(long id){
        return   jpaRepository.findOne(Goal.class,id);
    }
    public List<Goal> findAll(){
        return jpaRepository.findAll(Goal.class);
    }
}
