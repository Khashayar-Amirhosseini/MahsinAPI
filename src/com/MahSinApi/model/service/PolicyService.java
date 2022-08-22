package com.MahSinApi.model.service;

import com.MahSinApi.model.entity.Doctor;
import com.MahSinApi.model.entity.Like;
import com.MahSinApi.model.entity.Policy;
import com.MahSinApi.model.entity.User;
import com.MahSinApi.model.repository.JpaRepsitory;
import com.MahSinApi.model.repository.LikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PolicyService {
    @Autowired
    private JpaRepsitory<Policy,Long> jpaRepository;
    @Transactional
    public void save(Policy policy){
        jpaRepository.persist(policy);
    }
    @Transactional
    public void update(Policy policy) {
        jpaRepository.update(policy);
    }
    @Transactional
    public void delete(Policy policy){
        jpaRepository.delete(policy);
    }
    public Policy findOne(long id){
        return   jpaRepository.findOne(Policy.class,id);
    }
    public List<Policy> findAll(){
        return jpaRepository.findAll(Policy.class);
    }
}
