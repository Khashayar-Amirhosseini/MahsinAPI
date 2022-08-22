package com.MahSinApi.model.service;

import com.MahSinApi.exception.InvalidUserNameAndPasswordException;
import com.MahSinApi.model.entity.Role;
import com.MahSinApi.model.entity.User;
import com.MahSinApi.model.repository.JpaRepsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Service
public class RoleService {
    @Autowired
    private JpaRepsitory<Role,Long> jpaRepsitory;
    @Transactional
    public void save(Role role){
        jpaRepsitory.persist(role);
    }
    @Transactional
    public void update(Role role) {
        jpaRepsitory.update(role);
    }
    @Transactional
    public void delete(Role role){
        jpaRepsitory.delete(role);
    }
    public Role findOne(long id){
        return   jpaRepsitory.findOne(Role.class,id);
    }
    public List<Role> findAll(){
        return jpaRepsitory.findAll(Role.class);
    }

}
