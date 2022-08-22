package com.MahSinApi.model.service;
import com.MahSinApi.model.entity.Footer;
import com.MahSinApi.model.repository.JpaRepsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FooterService {
    @Autowired
    private JpaRepsitory<Footer,Long> jpaRepository;
    @Transactional
    public void save(Footer footer){
        jpaRepository.persist(footer);
    }
    @Transactional
    public void update(Footer footer) {
        jpaRepository.update(footer);
    }
    @Transactional
    public void delete(Footer footer){
        jpaRepository.delete(footer);
    }
    public Footer findOne(long id){
        return   jpaRepository.findOne(Footer.class,id);
    }
    public List<Footer> findAll(){
        return jpaRepository.findAll(Footer.class);
    }
}
