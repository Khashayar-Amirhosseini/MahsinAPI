package com.MahSinApi.model.service;

import com.MahSinApi.model.entity.Picture;
import com.MahSinApi.model.entity.User;
import com.MahSinApi.model.entity.UserPassword;
import com.MahSinApi.model.repository.JpaRepsitory;
import com.MahSinApi.model.repository.PasswordRepository;
import com.MahSinApi.model.repository.UserRepository;
import org.mortbay.jetty.security.Password;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PasswordService {
    @Autowired
    private JpaRepsitory<UserPassword,Long> jpaRepository;
    @Autowired
    private PasswordRepository passwordRepository;
    @Transactional
    public void save(UserPassword password){
        jpaRepository.persist(password);
    }
    @Transactional
    public void update(UserPassword password) {
        jpaRepository.update(password);
    }
    @Transactional
    public void delete(UserPassword password){
        jpaRepository.delete(password);
    }
    public UserPassword findOne(long id){
        return   jpaRepository.findOne(UserPassword.class,id);
    }
    public List<UserPassword> findAll(){
        return jpaRepository.findAll(UserPassword.class);
    }
    public UserPassword findByUser(User user){
        return passwordRepository.findPasswordByUser(user);
    }
    public UserPassword findByKey(String key){
        return passwordRepository.findByKey(key);
    }
}
