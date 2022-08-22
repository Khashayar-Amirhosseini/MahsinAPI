package com.MahSinApi.model.entity;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity(name="MAHSIN_USER")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotNull
    @Column(unique = true,columnDefinition = "text",name = "EMAIL")
    private String userName;
    @Column(nullable = false, columnDefinition = "text" ,name = "NAME")
    private String name;
    @Column(nullable = false, columnDefinition = "text",name = "FAMILY")
    private String family;
    @Column(nullable = false, name = "PHONE",columnDefinition = "text")
    private long phoneNumber;
    @Column(nullable = false, name = "JOIN_DATE",columnDefinition = "DATE")
    private Date date;
    @OneToMany(cascade = CascadeType.ALL)@JoinColumn(name = "USER_FK")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Role> roles;
    @Column(nullable = false, name = "BIRTH_DAY",columnDefinition = "DATE")
    private Date birthDay;
    //@Column(name = "INVITER",columnDefinition = "NUMBER(100)")
    @Column(name = "INVITER",columnDefinition = "integer")
    private Long inviter;
    @Version
    private long recordControl;



    public long getId() {
        return id;
    }

    public User setId(long id) {
        this.id = id;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public User setPersonEmail(String personEmail) {
        this.userName = personEmail;
        return this;
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public String getFamily() {
        return family;
    }

    public User setFamily(String family) {
        this.family = family;
        return this;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public User setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public User setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public User setRoles(List<Role> roles) {
        this.roles = roles;
        return this;
    }

    public long getRecordControl() {
        return recordControl;
    }

    public User setRecordControl(long recordControl) {
        this.recordControl = recordControl;
        return this;
    }

    public Date getDate() {
        return date;
    }

    public User setDate(Date date) {
        this.date = date;
        return this;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public User setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
        return this;
    }

    public Long getInviter() {
        return inviter;
    }

    public User setInviter(long inviter) {
        this.inviter = inviter;
        return this;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", personEmail='" + userName + '\'' +
                ", name='" + name + '\'' +
                ", family='" + family + '\'' +
                ", phoneNumber=" + phoneNumber +
                '}';
    }
}
