package com.MahSinApi;

import com.MahSinApi.model.entity.Role;
import com.MahSinApi.model.entity.User;
import com.MahSinApi.model.repository.JpaRepsitory;
import com.MahSinApi.model.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

public class Main {
    static JpaRepsitory jpaRepsitory=new JpaRepsitory<User,Long>();
    public static void main(String[] args) {


        Role role = new Role().setRoleName("admin");
        User user = new User().setName("khashayar")
                .setFamily("amirhosseini")
                .setPersonEmail("kh@g.com")
                .setPhoneNumber(1234);
        System.out.println(user.toString());
        jpaRepsitory.persist(user);

    }
}
