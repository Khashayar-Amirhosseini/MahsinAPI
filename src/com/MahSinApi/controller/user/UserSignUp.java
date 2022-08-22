package com.MahSinApi.controller.user;

import com.MahSinApi.model.entity.Role;
import com.MahSinApi.model.entity.User;
import com.MahSinApi.model.entity.UserPassword;
import com.MahSinApi.model.service.*;
import com.sun.mail.iap.Response;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.crypto.spec.SecretKeySpec;
import javax.validation.Valid;
import java.security.Key;
import java.util.*;

@RestController
public class UserSignUp {
    @Autowired
    private UserService userService;
    @Autowired
    private PasswordService passwordService;
    @Autowired
    private UserDetailService userDetailService;
    @Autowired
    private RoleService roleService;

    @RequestMapping(value = "/userSignUp.do",method = RequestMethod.POST)
    public Object userSignUp(@RequestParam String userName,
                             @RequestParam String name,
                             @RequestParam String family,
                             @RequestParam String phoneNumber,
                             @RequestParam long birthDay,
                             @RequestParam long inviterCode,
                             @RequestParam String providedPassword){
        User user=new User().setName(name).setFamily(family).setPhoneNumber(Long.parseLong(phoneNumber)).setUserName(userName.toLowerCase()).setBirthDay(new Date(birthDay)).setInviter(inviterCode);

        PassEncTech4 passEncTech4=new PassEncTech4();
        String saltValue=  PassEncTech4.getSaltvalue(20);
        UserPassword userPassword=new UserPassword().setSecurityKey(saltValue).setPassword(passEncTech4.generateSecurePassword(providedPassword,saltValue));

        //user.setSecurityKey(saltValue);
       // user.setPassword(passEncTech4.generateSecurePassword(user.getPassword(),saltValue));
        HashMap map=new HashMap();
        try {
            user.setDate(new Date(System.currentTimeMillis()));
            user.setRecordControl(1);
            userService.save(user);
            userPassword.setUser(user);
            passwordService.save(userPassword);
            map.put("state","ok");
            map.put("userId",user.getId());
            map.put("username",user.getUserName());
            map.put("name",user.getName());
            map.put("family",user.getFamily());
            map.put("date",user.getDate());
            map.put("birthDay",user.getBirthDay());
            map.put("inviterCode",user.getInviter());
            map.put("token",userDetailService.loadUserByUsername(userName,providedPassword));
            System.out.println("user has been registered:");
            System.out.println(user);
            return map;
        }
        catch (Exception e){
            if(e.getMessage().contains("ORA-00001: unique constraint")) {
                map.put("state","not ok");
                map.put("message","ایمیل انتخاب شده تکراری است.");
                System.out.println(e);
                return map;
            }
            System.out.println(e);
             return e;
        }
    }
    @RequestMapping(value = "/user/userEdit.do",method = RequestMethod.POST)
    public Object userUpdate(@RequestParam long id,
                             @RequestParam String name,
                             @RequestParam String family,
                             @RequestParam long phoneNumber,
                             @RequestParam long birthDay){

        HashMap map=new HashMap();
        try {
            User user=userService.findOne(id);
            user.setName(name).setFamily(family).setPhoneNumber(phoneNumber).setBirthDay(new Date(birthDay))
            .setRecordControl(userService.findOne(user.getId()).getRecordControl());
            userService.update(user);
            map.put("state","ok");
            map.put("userId",user.getId());
            map.put("username",user.getUserName());
            map.put("name",user.getName());
            map.put("family",user.getFamily());
            map.put("date",user.getDate());
            map.put("birthDay",user.getBirthDay());
            map.put("inviterCode",user.getInviter());
            return map;
        }
        catch (Exception e){
            if(e.getMessage().contains("ORA-00001: unique constraint")) {
                map.put("state","not ok");
                map.put("message","ایمیل انتخاب شده تکراری است.");
                System.out.println(e);
                return map;
            }
            System.out.println(e);
            return e;
        }
    }

    @RequestMapping(value = "/user/changePassword.do",method = RequestMethod.POST)
    public Object updatePassword(@RequestParam long id,
                             @RequestParam String oldPassword,
                             @RequestParam String newPassword){


        PassEncTech4 passEncTech4=new PassEncTech4();
        HashMap map=new HashMap();
        try {
            User user=userService.findOne(id);
            UserPassword userPassword=passwordService.findByUser(user);
            if(passEncTech4.verifyUserPassword(oldPassword,userPassword.getPassword(),userPassword.getSecurityKey())){
                user.setRecordControl(user.getRecordControl());
                String saltValue=  PassEncTech4.getSaltvalue(20);
                userPassword.setSecurityKey(saltValue).setPassword(passEncTech4.generateSecurePassword(newPassword,saltValue));
                passwordService.update(userPassword);
                userService.update(user);
                map.put("state","ok");
                map.put("userId",user.getId());
                map.put("username",user.getUserName());
                map.put("name",user.getName());
                map.put("family",user.getFamily());
                map.put("date",user.getDate());
                map.put("birthDay",user.getBirthDay());
                map.put("inviterCode",user.getInviter());
            }
            else {
                map.put("state","not ok");
                map.put("message","پسورد وارد شده صحیح نیست.");
            }
            return map;
        }
        catch (Exception e){
                map.put("state","not ok");
                map.put("message",e.getMessage());
                System.out.println(e);
                return map;
        }
    }

    @RequestMapping(value = "/forgotPassword.do", method=RequestMethod.POST)
    public Object forgotPassword(@RequestParam String userName){
        HashMap map=new HashMap();
        try{
        User user=userService.findUserByUsername(userName);
        UserPassword userPassword=passwordService.findByUser(user);
        map.put("securityKey",userPassword.getSecurityKey());
        return map;}
        catch (Exception e){
            return "user Not found";
        }
    }

    @RequestMapping(value = "/retrievePassword.do",method = RequestMethod.POST)
    public Object retrievePassword(@RequestParam String pass,
                                   @RequestParam String key){
        PassEncTech4 passEncTech4=new PassEncTech4();
        try {
            UserPassword userPassword=passwordService.findByKey(key);
            String saltValue=  PassEncTech4.getSaltvalue(20);
            userPassword.setSecurityKey(saltValue).setPassword(passEncTech4.generateSecurePassword(pass,saltValue));
            passwordService.update(userPassword);
            return "password retrieved";
        }
        catch (Exception e){
            return e;
        }
    }

    @RequestMapping(value = "/management/userFindAll.do")
    public Object findAllUsers(){

        try {
             List<User> userList= userService.findAll();
             List<Object> users=new ArrayList<>();
             for (User user:userList){
                 HashMap map=new HashMap();
                 map.put("id",user.getId());
                 map.put("name",user.getName());
                 map.put("family",user.getFamily());
                 map.put("phoneNumber",user.getPhoneNumber());
                 map.put("email",user.getUserName());
                 map.put("roles",user.getRoles());
                 map.put("joinDate",user.getDate());
                 map.put("birthDay",user.getBirthDay());
                 map.put("inviterCode",user.getInviter());
                 users.add(map);
             }
            System.out.println("all users have been fetched");
             return users;
        }
        catch (Exception e){
            System.out.println(e.getStackTrace());
            return e;
        }
    }


}
