package com.MahSinApi.model.entity;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity(name = "DOCTORS")
public class Doctor {
    @Id@GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "NAME",nullable = false,columnDefinition = "text")
    private String name;
    @Column(name = "FAMILY",nullable = false,columnDefinition = "text")
    private String family;
    //@Column(name = "MEDICAL_ID",nullable = false,columnDefinition = "NUMBER")
    @Column(name = "MEDICAL_ID",nullable = false,columnDefinition = "INT")
    private long medicalId;
    @Column(name = "STATE",columnDefinition = "text")
    private String state;
   // @Lob@Column(name = "ABOUT",columnDefinition = "CLOB")
    @Lob@Column(name = "ABOUT",columnDefinition = "text")
    private String about;
    @Column(name= "LAST_UPDATE_DATE",columnDefinition = "DATE")
    private Date LastUpdateDate;
    @OneToOne@JoinColumn(name = "USER_FK")
    private User user;
    @Version
    private long recordControl;



    public long getId() {
        return id;
    }

    public Doctor setId(long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Doctor setName(String name) {
        this.name = name;
        return this;
    }

    public String getFamily() {
        return family;
    }

    public Doctor setFamily(String family) {
        this.family = family;
        return this;
    }

    public long getMedicalId() {
        return medicalId;
    }

    public Doctor setMedicalId(long medicalId) {
        this.medicalId = medicalId;
        return this;
    }

    public String isState() {
        return state;
    }

    public Doctor setState(String state) {
        this.state = state;
        return this;
    }

    public String getAbout() {
        return about;
    }

    public Doctor setAbout(String about) {
        this.about = about;
        return this;
    }

    public Date getLastUpdateDate() {
        return LastUpdateDate;
    }

    public Doctor setLastUpdateDate(Date lastUpdateDate) {
        LastUpdateDate = lastUpdateDate;
        return this;
    }

    public User getUser() {
        return user;
    }

    public Doctor setUser(User user) {
        this.user = user;
        return this;
    }

    public String getState() {
        return state;
    }

    public long getRecordControl() {
        return recordControl;
    }

    public Doctor setRecordControl(long recordControl) {
        this.recordControl = recordControl;
        return this;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", family='" + family + '\'' +
                ", medicalId=" + medicalId +
                ", state='" + state + '\'' +
                ", about='" + about + '\'' +
                ", LastUpdateDate=" + LastUpdateDate +
                ", user=" + user +
                '}';
    }
}
