package com.MahSinApi.controller;

import com.MahSinApi.model.entity.Role;
import com.MahSinApi.model.entity.User;
import com.MahSinApi.model.service.RoleService;
import com.MahSinApi.model.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class UserManagementConteroller {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    @RequestMapping("/userSave.do")
    public Object saveUser(){
        try {

            System.out.println("role saved");
            User user = new User().setName("khashayar")
                    .setFamily("amirhosseini")
                    .setPersonEmail("kh@g.com")
                    .setPhoneNumber(1234)
                    .setRecordControl(1);
            userService.save(user);
            Role role = new Role().setRoleName("admin");
            roleService.save(role);

            System.out.println(user.toString());
            return user;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return e.getMessage();
        }


    }

}
