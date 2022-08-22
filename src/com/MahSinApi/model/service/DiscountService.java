package com.MahSinApi.model.service;

import com.MahSinApi.model.entity.Discount;
import com.MahSinApi.model.entity.Doctor;
import com.MahSinApi.model.entity.User;
import com.MahSinApi.model.repository.DiscountRepository;
import com.MahSinApi.model.repository.JpaRepsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DiscountService {
    @Autowired
    private JpaRepsitory<Discount,Long> jpaRepository;
    @Autowired
    private DiscountRepository discountRepository;
    @Transactional
    public void save(Discount discount){
        jpaRepository.persist(discount);
    }
    @Transactional
    public void update(Discount discount) {
        jpaRepository.update(discount);
    }
    @Transactional
    public void delete(Discount discount){
        jpaRepository.delete(discount);
    }
    public Discount findOne(long id){
        return   jpaRepository.findOne(Discount.class,id);
    }
    public List<Discount> findAll(){
        return jpaRepository.findAll(Discount.class);
    }
    public List<Discount> findByUser(User customer){
        return discountRepository.getDiscountByUser(customer);
    }
    public Discount findOnebyCode(String code){
        return discountRepository.getDiscountByCode(code);
    }
}
