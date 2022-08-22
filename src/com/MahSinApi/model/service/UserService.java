package com.MahSinApi.model.service;

import com.MahSinApi.model.entity.User;
import com.MahSinApi.model.repository.JpaRepsitory;
import com.MahSinApi.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
@Service
public class UserService {
    @Autowired
    private JpaRepsitory<User,Long> jpaRepository;
    @Autowired
    private UserRepository userRepository;

    @Transactional
    public void save(User user){
        jpaRepository.persist(user);
    }
    @Transactional
    public void update(User user) {
        jpaRepository.update(user);
    }
    @Transactional
    public void delete(User user){
        jpaRepository.delete(user);
    }
    public User findOne(long id){
        return   jpaRepository.findOne(User.class,id);
    }
    public List<User> findAll(){
        return jpaRepository.findAll(User.class);
    }
    public User findUserByUsername(String userName){
        return userRepository.findUserByUserName(userName);
    }


}
