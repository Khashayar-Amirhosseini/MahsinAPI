package com.MahSinApi.model.service;


import com.MahSinApi.exception.InvalidUserNameAndPasswordException;
import com.MahSinApi.model.entity.Role;
import com.MahSinApi.model.entity.User;
import com.MahSinApi.model.entity.UserPassword;
import com.MahSinApi.model.repository.PasswordRepository;
import com.MahSinApi.model.repository.UserRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;
@Service
public class UserDetailService  {
    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordRepository passwordRepository;
    PassEncTech4 passEncTech4=new PassEncTech4();
    public String loadUserByUsername(String username,String password) throws UsernameNotFoundException, InvalidUserNameAndPasswordException {
        User user=userRepository.findUserByUserName(username);
        if(user!=null){
            UserPassword userPassword=passwordRepository.findPasswordByUser(user);
            if(passEncTech4.verifyUserPassword(password,userPassword.getPassword(),userPassword.getSecurityKey())){
                String secret = "";
                Key hmacKey = new SecretKeySpec(Base64.getDecoder().decode(secret),
                        SignatureAlgorithm.HS256.getJcaName());
                HashMap map=new HashMap();
                map.put("alg","HS256");
                map.put("typ","JWT");
                String jwtToke= Jwts.builder().
                        setHeader(map).
                        claim("id",user.getId()).
                        claim("email",user.getUserName()).
                        claim("name",user.getName()).
                        claim("family",user.getFamily()).
                        claim("phoneNumber",user.getPhoneNumber()).
                        claim("admin",roleCheck("admin",user.getRoles())).
                        claim("user",roleCheck("user",user.getRoles())).
                        claim("doctor",roleCheck("doctor",user.getRoles())).
                        claim("achievement",roleCheck("achievement",user.getRoles())).
                        claim("facility",roleCheck("facility",user.getRoles())).
                        claim("goal",roleCheck("goal",user.getRoles())).
                        claim("history",roleCheck("history",user.getRoles())).
                        claim("blogger",roleCheck("blogger",user.getRoles())).
                        claim("service",roleCheck("service",user.getRoles())).
                        claim("policy",roleCheck("policy",user.getRoles())).
                        claim("picture",roleCheck("picture",user.getRoles())).
                        claim("footer",roleCheck("footer",user.getRoles())).
                        claim("management",roleCheck("management",user.getRoles())).
                        claim("role",roleCheck("role",user.getRoles())).
                        claim("discount",roleCheck("discount",user.getRoles())).
                        claim("viewer",roleCheck("viewer",user.getRoles())).
                        setId(UUID.randomUUID().toString())
                        .setIssuedAt(Date.from(Instant.now()))
                        .setExpiration(Date.from(Instant.now().plus(60l, ChronoUnit.MINUTES)))
                        .signWith(hmacKey)
                        .compact();
                return jwtToke;
            }
            else {
                throw new InvalidUserNameAndPasswordException();
            }
        }
        else {
            throw new UsernameNotFoundException("User has not registered");
        }
    }

    public boolean roleCheck(String roleName,List<Role> roles){
        boolean isGranted=false;
        for(Role role:roles){
            if(role.getRoleName().equals(roleName)){
                isGranted=true;
            }
        }
        return isGranted;
    }
}
