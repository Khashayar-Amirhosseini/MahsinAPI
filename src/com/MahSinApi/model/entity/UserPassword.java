package com.MahSinApi.model.entity;

import javax.persistence.*;

@Entity(name = "USER_PASSWORD")
public class UserPassword {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false, name = "PASSWORD")
    private String password;
    @Column(nullable = false,name = "SECURITY_KEY")
    private String securityKey;
    @OneToOne@JoinColumn(name = "USER_FK")
    private User user;

    public long getId() {
        return id;
    }

    public UserPassword setId(long id) {
        this.id = id;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserPassword setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getSecurityKey() {
        return securityKey;
    }

    public UserPassword setSecurityKey(String securityKey) {
        this.securityKey = securityKey;
        return this;
    }

    public User getUser() {
        return user;
    }

    public UserPassword setUser(User user) {
        this.user = user;
        return this;
    }
}
