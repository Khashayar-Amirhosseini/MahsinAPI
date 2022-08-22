package com.MahSinApi.model.service;

import com.MahSinApi.model.entity.Goal;
import com.MahSinApi.model.entity.MainService;
import com.MahSinApi.model.repository.JpaRepsitory;
import com.MahSinApi.model.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.MahSinApi.model.entity.Service;

import java.util.List;

@org.springframework.stereotype.Service
public class ServiceService {
    @Autowired
    private JpaRepsitory<Service,Long> jpaRepository;
    @Autowired
    private ServiceRepository serviceRepository;
    @Transactional
    public void save(Service service){
        jpaRepository.persist(service);
    }
    @Transactional
    public void update(Service service) {
        jpaRepository.update(service);
    }
    @Transactional
    public void delete(Service service){
        jpaRepository.delete(service);
    }
    public Service findOne(long id){
        return   jpaRepository.findOne(Service.class,id);
    }
    public List<Service> findAll(){
        return jpaRepository.findAll(Service.class);
    }
    public MainService findMainService(Service service){
        return serviceRepository.findMainService(service);
    }
}
