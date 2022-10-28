package com.MahSinApi.controller.auth;

import com.MahSinApi.common.ExceptionWrapper;
import com.MahSinApi.model.entity.Role;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.commons.collections.map.HashedMap;

import javax.crypto.spec.SecretKeySpec;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.AccessDeniedException;
import java.security.Key;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request=(HttpServletRequest)servletRequest;
        HttpServletResponse response=(HttpServletResponse)  servletResponse;
        String jwtToken=request.getHeader("Access-Token");
        System.out.println(jwtToken);
        //String jwtToken=request.getParameter("accessToken");
        File file=new File("C:\\key\\key.txt");
        BufferedReader bufferedReader=new BufferedReader(new FileReader(file));
        String secret=bufferedReader.readLine();
        System.out.println(secret);
        Key hmacKey = new SecretKeySpec(Base64.getDecoder().decode(secret),
                SignatureAlgorithm.HS256.getJcaName());
        System.out.println(request.getRequestURI());
        try {
            Jws<Claims> jwt = Jwts.parserBuilder()
                    .setSigningKey(hmacKey)
                    .build()
                    .parseClaimsJws(jwtToken);
            List<String> requestAddressList = Arrays.asList(request.getRequestURI().split("/"));
            String requestAddress = requestAddressList.get(3);
            System.out.println(requestAddress);
            System.out.println(jwt.getBody().toString());
            if (jwt.getBody().get(requestAddress).equals(true)) {
                System.out.println("ok");
                filterChain.doFilter(servletRequest, servletResponse);
            } else {
                System.out.println(requestAddress);
                System.out.println("Attack On " + request.getRemoteAddr());
                System.out.println(ExceptionWrapper.getMessage(new AccessDeniedException("Access Denied")));
                //response.setHeader("Access-Control-Allow-Headers", ExceptionWrapper.getMessage(new AccessDeniedException("AccessDenied")));
                response.sendError(700);
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            response.sendError(700);
        }
        //String CurrentRole="";
        /*if (roles != null) {
            for (Role role : roles) {
                String R=role.getRoleName();
                switch (R){
                    case "admin":
                        CurrentRole="admin";
                        break;
                    case "user":
                        CurrentRole="user";
                        break;
                    case "guest":
                        CurrentRole="inspector";
                        break;
                }
                if (CurrentRole.equals(requestAddress)) {
                    filterChain.doFilter(servletRequest, servletResponse);

                    return;
                }
            }
        }*/

    }

    @Override
    public void destroy() {

    }
}
