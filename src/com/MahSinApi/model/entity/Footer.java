package com.MahSinApi.model.entity;

import javax.persistence.*;
import java.util.Date;

@Entity(name="Footer")
public class Footer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Lob
    //@Column(name = "INSTAGRAM",columnDefinition = "clob")
    @Column(name = "INSTAGRAM",columnDefinition = "text")
    private String instagram;
    @Lob
    @Column(name = "TELEGRAM",columnDefinition = "text")
    //@Column(name = "TELEGRAM",columnDefinition = "clob")
    private String telegram;
    @Lob
    @Column(name = "EMAIL",columnDefinition = "text")
    //@Column(name = "EMAIL",columnDefinition = "clob")
    private String email ;
    @Column(name = "TEL1",columnDefinition = "text")
    private String tel1;
    @Column(name = "TEL2",columnDefinition = "text")
    private String tel2;
    @Column(name = "TEL3",columnDefinition = "text")
    private String tel3;
    @Lob
    //@Column(name = "ADDRESS",columnDefinition = "clob",nullable = false)
    @Column(name = "ADDRESS",columnDefinition = "text",nullable = false)
    private String address;
    @Lob
    //@Column(name = "MAP_SRC",columnDefinition = "clob",nullable = false)
    @Column(name = "MAP_SRC",columnDefinition = "text",nullable = false)
    private String mapSRC;
    @Column(name = "CONSULTANT_TEL",columnDefinition = "text",nullable = false)
    private String consultantNumber;
    @OneToOne@JoinColumn(name = "USER_FK")
    private User user;
    @Column(name = "FOOTER_DATE",columnDefinition = "timestamptz",nullable = false)
    private Date date;
    @Version
    private long recordControl;
    @Column(name = "STATE",columnDefinition = "text",nullable = false)
    private String state;

    public long getId() {
        return id;
    }

    public Footer setId(long id) {
        this.id = id;
        return this;
    }

    public String getInstagram() {
        return instagram;
    }

    public Footer setInstagram(String instagram) {
        this.instagram = instagram;
        return this;
    }

    public String getTelegram() {
        return telegram;
    }

    public Footer setTelegram(String telegram) {
        this.telegram = telegram;
        return this;
    }

    public String getTel1() {
        return tel1;
    }

    public Footer setTel1(String tel1) {
        this.tel1 = tel1;
        return this;
    }

    public String getTel2() {
        return tel2;
    }

    public Footer setTel2(String tel2) {
        this.tel2 = tel2;
        return this;
    }

    public String getTel3() {
        return tel3;
    }

    public Footer setTel3(String tel3) {
        this.tel3 = tel3;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public Footer setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getMapSRC() {
        return mapSRC;
    }

    public Footer setMapSRC(String mapSRC) {
        this.mapSRC = mapSRC;
        return this;
    }

    public User getUser() {
        return user;
    }

    public Footer setUser(User user) {
        this.user = user;
        return this;
    }

    public Date getDate() {
        return date;
    }

    public Footer setDate(Date date) {
        this.date = date;
        return this;
    }

    public long getRecordControl() {
        return recordControl;
    }

    public Footer setRecordControl(long recordControl) {
        this.recordControl = recordControl;
        return this;
    }

    public String getState() {
        return state;
    }

    public Footer setState(String state) {
        this.state = state;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Footer setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getConsultantNumber() {
        return consultantNumber;
    }

    public Footer setConsultantNumber(String consultantNumber) {
        this.consultantNumber = consultantNumber;
        return this;
    }

    @Override
    public String toString() {
        return "Footer{" +
                "id=" + id +
                ", instagram='" + instagram + '\'' +
                ", telegram='" + telegram + '\'' +
                ", email='" + email + '\'' +
                ", tel1='" + tel1 + '\'' +
                ", tel2='" + tel2 + '\'' +
                ", tel3='" + tel3 + '\'' +
                ", address='" + address + '\'' +
                ", mapSRC='" + mapSRC + '\'' +
                ", consultantNumber='" + consultantNumber + '\'' +
                ", user=" + user.toString() +
                ", date=" + date +
                ", recordControl=" + recordControl +
                ", state='" + state + '\'' +
                '}';
    }
}
