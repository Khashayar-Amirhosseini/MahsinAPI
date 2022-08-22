package com.MahSinApi.model.service;

import com.MahSinApi.exception.InvalidUserNameAndPasswordException;
import com.MahSinApi.model.entity.History;
import com.MahSinApi.model.entity.Role;
import com.MahSinApi.model.repository.JpaRepsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Service
public class HistoryService {
    @Autowired
    private JpaRepsitory<History,Long> jpaRepsitory;
    @Transactional
    public void save(History history){
        jpaRepsitory.persist(history);
    }
    @Transactional
    public void update(History history){
        jpaRepsitory.update(history);
    }
    @Transactional
    public void delete(History history){
        jpaRepsitory.delete(history);
    }
    public History findOne(long id){
        return   jpaRepsitory.findOne(History.class,id);
    }
    public List<History> findAll(){
        return jpaRepsitory.findAll(History.class);
    }
}
