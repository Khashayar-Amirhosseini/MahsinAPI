package com.MahSinApi.model.entity;

import javax.persistence.*;
import java.util.Date;

@Entity(name="FACILITIES")
public class Facility {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "NAME",columnDefinition = "text",nullable = false)
    private String name;
    //@Column(name = "UTILITY",columnDefinition = "CLOB",nullable = false)
    @Column(name = "UTILITY",columnDefinition = "text",nullable = false)
    @Lob
    private String utility;
    //@Column(name = "DESCRIPTION",columnDefinition = "CLOP",nullable = false)
    @Column(name = "DESCRIPTION",columnDefinition = "text",nullable = false)
    @Lob
    private String description;
    @OneToOne@JoinColumn(name = "USER_FK")
    private User user;
    @Column(name = "FACILITY_DATE",columnDefinition = "timestamptz",nullable = false)
    private Date date;
    @Version
    private long recordControl;
    @Column(name = "STATE",columnDefinition = "text",nullable = false)
    private String state;

    public long getId() {
        return id;
    }

    public Facility setId(long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Facility setName(String name) {
        this.name = name;
        return this;
    }

    public String getUtility() {
        return utility;
    }

    public Facility setUtility(String utility) {
        this.utility = utility;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Facility setDescription(String description) {
        this.description = description;
        return this;
    }

    public User getUser() {
        return user;
    }

    public Facility setUser(User user) {
        this.user = user;
        return this;
    }

    public Date getDate() {
        return date;
    }

    public Facility setDate(Date date) {
        this.date = date;
        return this;
    }

    public long getRecordControl() {
        return recordControl;
    }

    public Facility setRecordControl(long recordControl) {
        this.recordControl = recordControl;
        return this;
    }

    public String getState() {
        return state;
    }

    public Facility setState(String state) {
        this.state = state;
        return this;
    }

    @Override
    public String toString() {
        return "Facility{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", utility='" + utility + '\'' +
                ", description='" + description + '\'' +
                ", user=" + user.toString() +
                ", date=" + date +
                ", recordControl=" + recordControl +
                ", state='" + state + '\'' +
                '}';
    }
}
