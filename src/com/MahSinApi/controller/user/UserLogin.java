package com.MahSinApi.controller.user;

import com.MahSinApi.common.ExceptionWrapper;
import com.MahSinApi.model.entity.User;
import com.MahSinApi.model.service.UserDetailService;
import com.MahSinApi.model.service.UserService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.security.Key;
import java.util.Base64;
import java.util.HashMap;

@RestController()
public class UserLogin {
    @Autowired
    private UserDetailService userDetailService;
    @RequestMapping(value = "/login.do",method = RequestMethod.POST)
    protected  Object userLogin (@RequestParam String userName,
                                         @RequestParam String password,
                                         HttpServletRequest httpServletRequest,
                                         HttpServletResponse httpServletResponse){
        try {
            String jwtToken=userDetailService.loadUserByUsername(userName.toLowerCase(),password);
            httpServletResponse.setHeader("Access-Control-Allow-Headers",jwtToken);
            File file=new File("C:\\key\\key.txt");
            BufferedReader bufferedReader=new BufferedReader(new FileReader(file));
            String secret=bufferedReader.readLine();
            Key hmacKey = new SecretKeySpec(Base64.getDecoder().decode(secret),
                    SignatureAlgorithm.HS256.getJcaName());

            Jws<Claims> jwt = Jwts.parserBuilder()
                    .setSigningKey(hmacKey)
                    .build()
                    .parseClaimsJws(jwtToken);

            HashMap map=new HashMap();
            map.put("userInf",jwt.getBody());
            map.put("token",jwtToken);
            return map ;
        }
        catch (Exception e){
          httpServletResponse.setHeader("Access-Control-Allow-Headers", ExceptionWrapper.getMessage(e));

        }
        return null;
    }
}
