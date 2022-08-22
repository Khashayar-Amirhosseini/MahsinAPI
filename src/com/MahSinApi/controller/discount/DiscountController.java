package com.MahSinApi.controller.discount;

import com.MahSinApi.common.ServerAddress;
import com.MahSinApi.model.entity.Discount;
import com.MahSinApi.model.entity.Doctor;
import com.MahSinApi.model.service.DiscountService;
import com.MahSinApi.model.service.DoctorService;
import com.MahSinApi.model.service.LikeService;
import com.MahSinApi.model.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
public class DiscountController {
    @Autowired
    private DiscountService discountService;
    @Autowired
    private UserService userService;
    @RequestMapping(value = "/discount/saveDiscount.do",method= RequestMethod.POST)
    public Object saveDiscount(@RequestParam String name,
                               @RequestParam String description,
                               @RequestParam long expiredDate,
                               @RequestParam long customerId,
                               @RequestParam long userId) {
        try {
            Discount discount=new Discount()
                    .setName(name)
                    .setDescription(description)
                    .setExpiredDate(new Date(expiredDate))
                    .setUser(userService.findOne(userId))
                    .setRecordControl(1)
                    .setCreationDate(new Date(System.currentTimeMillis()))
                    .setState("active")
                    .setCustomer(userService.findOne(customerId));
            discountService.save(discount);
            discount.setCode("MS-"+discount.getId());
            discountService.update(discount);
            System.out.println("discount has been saved");
            return discount;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return e;
        }
    }

    @RequestMapping(value = "/discount/updateDiscount.do",method = RequestMethod.POST)
    public Object updateDoctor(@RequestParam long id,
                               @RequestParam String name,
                               @RequestParam String description,
                               @RequestParam long creationDate,
                               @RequestParam long expiredDate,
                               @RequestParam String state,
                               @RequestParam long userId,
                               @RequestParam long customerId){
        try {
            Discount discount=discountService.findOne(id).setName(name)
                    .setDescription(description)
                    .setCreationDate(new Date(creationDate))
                    .setExpiredDate(new Date(expiredDate))
                    .setCode(discountService.findOne(id).getCode())
                    .setState(state)
                    .setUser(userService.findOne(userId))
                    .setCustomer(userService.findOne(customerId))
                    .setRecordControl(discountService.findOne(id).getRecordControl());
            discountService.update(discount);
            System.out.println("the mentioned discount has been updated");
            return discount;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return e;
        }
    }

    @RequestMapping("/user/findAllDiscount.do")
    public Object findAllDiscounts(@RequestParam long customerId){
        try {
            return discountService.findByUser(userService.findOne(customerId));
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return e;
        }
    }
    @RequestMapping("/discount/findDiscountByCode.do")@ResponseBody
    public Object findOneByCode(@RequestParam String code){
        try {
            return discountService.findOnebyCode(code);
        }
        catch (Exception e){
            return e ;
        }
    }

    @RequestMapping("/discount/deleteDiscount.do")
    public Object deleteDoctor(@RequestParam String code){
        try {
            Discount discount=discountService.findOnebyCode(code);
            discountService.delete(discount);
            HashMap<String,Object> map=new HashMap<String,Object>();
            map.put("result","ok");

            return map;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return e;
        }
    }

    @RequestMapping("/discount/findAll.do")
    public Object findAll(){
        try {
            return discountService.findAll();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return e;
        }
    }



}
