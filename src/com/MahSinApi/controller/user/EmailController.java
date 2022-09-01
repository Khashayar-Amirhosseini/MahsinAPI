package com.MahSinApi.controller.user;

import com.MahSinApi.model.entity.Role;
import com.MahSinApi.model.entity.User;
import com.MahSinApi.model.service.PasswordService;
import com.MahSinApi.model.service.RoleService;
import com.MahSinApi.model.service.UserDetailService;
import com.MahSinApi.model.service.UserService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@Controller
public class EmailController {
    @Autowired
    private UserService userService;
    @Autowired
    private PasswordService passwordService;
    @Autowired
    private UserDetailService userDetailService;
    @Autowired
    private RoleService roleService;

    @RequestMapping("/userActivate.do")
    public Object userActivate(@RequestParam String token){

        String jwtToken=token;
        String secret = "asdfSFS34wfsdfsdfSDSD32dfsddDDerQSNCK34SOWEK5354fdgdf4";
        Key hmacKey = new SecretKeySpec(Base64.getDecoder().decode(secret),
                SignatureAlgorithm.HS256.getJcaName());
        try {
            Jws<Claims> jwt = Jwts.parserBuilder()
                    .setSigningKey(hmacKey)
                    .build()
                    .parseClaimsJws(jwtToken);
            Role role=new Role().setRoleName("user");
            roleService.save(role);
            User user=userService.findOne( new Long(jwt.getBody().get("id").toString()));
            Boolean hasRole=false;
            List<Role> roleList=user.getRoles();
            for (Role r:roleList){
                if(r.getRoleName().equals("user")){
                   hasRole=true;
                    return "redirect:http://89.32.250.218:8080/mahsin";
                }
            }
            user.getRoles().add(role);
            userService.update(user);
            return "redirect:http://89.32.250.218:8080/MahsinApi/welcomePage.jsp";
        }
        catch (Exception e){
            System.out.println(e);
            return "redirect:http://89.32.250.218:8080/mahsin";
        }

    }
}
