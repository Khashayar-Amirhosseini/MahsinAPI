package com.MahSinApi.model.service;

import com.MahSinApi.exception.InvalidUserNameAndPasswordException;
import com.MahSinApi.model.entity.Doctor;
import com.MahSinApi.model.entity.User;
import com.MahSinApi.model.repository.JpaRepsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Service
public class DoctorService {
    @Autowired
    private JpaRepsitory<Doctor,Long> jpaRepository;
    @Transactional
    public void save(Doctor doctor){
        jpaRepository.persist(doctor);
    }
    @Transactional
    public void update(Doctor doctor) {
        jpaRepository.update(doctor);
    }
    @Transactional
    public void delete(Doctor doctor){
        jpaRepository.delete(doctor);
    }
    public Doctor findOne(long id){
        return   jpaRepository.findOne(Doctor.class,id);
    }
    public List<Doctor> findAll(){
        return jpaRepository.findAll(Doctor.class);
    }
}
