package com.MahSinApi.model.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity(name = "DISCOUNTS")
public class Discount {
    @Id@GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "NAME",nullable = false,columnDefinition = "text")
    private String name;
    //@Lob@Column(name = "DESCRIPTION",columnDefinition = "CLOB")
    @Column(name = "DESCRIPTION",columnDefinition = "text")
    private String description;
    @Column(name= "CREATION_DATE",columnDefinition = "DATE")
    private Date creationDate;
    @Column(name= "EXPIRED_DATE",columnDefinition = "DATE")
    private Date expiredDate;
    @OneToOne@JoinColumn(name = "USER_FK")
    private User user;
    @OneToOne@JoinColumn(name = "CUSTOMER_FK")
    private User customer;
    @Column(name= "STATE",columnDefinition = "text")
    private String state;
    @Column(name= "CODE",columnDefinition = "text")
    private String code;
    @Version
    private long recordControl;

    public long getId() {
        return id;
    }

    public Discount setId(long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Discount setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Discount setDescription(String description) {
        this.description = description;
        return this;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public Discount setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
        return this;
    }

    public Date getExpiredDate() {
        return expiredDate;
    }

    public Discount setExpiredDate(Date expiredDate) {
        this.expiredDate = expiredDate;
        return this;
    }

    public User getUser() {
        return user;
    }

    public Discount setUser(User user) {
        this.user = user;
        return this;
    }

    public User getCustomer() {
        return customer;
    }

    public Discount setCustomer(User customer) {
        this.customer = customer;
        return this;
    }

    public long getRecordControl() {
        return recordControl;
    }

    public Discount setRecordControl(long recordControl) {
        this.recordControl = recordControl;
        return this;
    }

    public String getState() {
        return state;
    }

    public Discount setState(String state) {
        this.state = state;
        return this;
    }

    public String getCode() {
        return code;
    }

    public Discount setCode(String code) {
        this.code = code;
        return this;
    }


}
