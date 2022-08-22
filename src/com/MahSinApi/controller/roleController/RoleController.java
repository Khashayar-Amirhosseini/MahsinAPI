package com.MahSinApi.controller.roleController;

import com.MahSinApi.model.entity.MainService;
import com.MahSinApi.model.entity.Role;
import com.MahSinApi.model.entity.Service;
import com.MahSinApi.model.entity.User;
import com.MahSinApi.model.service.RoleService;
import com.MahSinApi.model.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
public class RoleController {
    @Autowired
    private RoleService roleService;
    @Autowired
    private UserService userService;
    @RequestMapping("/role/saveRole.do")
    public Object saveRole(@ModelAttribute Role role,
                              @RequestParam long userId){
        try {
            role.setRecordControl(1);
            User user=userService.findOne(userId);
            user.getRoles().add(role);
            roleService.save(role);
            userService.update(user);
            System.out.println("role has been saved");
            System.out.println(role.toString());
            return role;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return e;
        }
    }

    @RequestMapping("/role/findOneRole.do")
    public Object findOneRole(@RequestParam long id){
        try {
            Role role=roleService.findOne(id);
            System.out.println("Role has been fetched");
            System.out.println(role.toString());
            return role;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return e;
        }
    }
    @RequestMapping("/role/findAllRoles.do")
    public Object findAllRoles(){
        try {
            List<Role> roles=roleService.findAll();
            System.out.println("All roles have been fetched");
            return roles;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return e;
        }
    }
    @RequestMapping("/role/deleteRole.do")
    public Object deleteService(@RequestParam long roleId){
        try {
            Role role=roleService.findOne(roleId);
            roleService.delete(role);
            System.out.println(role.toString());
            System.out.println("the mentioned service has been deleted");
            return "role has been deleted";
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return e;
        }
    }
}
