package com.MahSinApi.model.entity;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "SERVICES")
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "TITLE",columnDefinition = "text",nullable = false)
    private String title;
    ///@Column(name = "DESCRIPTION",columnDefinition = "CLOP",nullable = false)
    @Column(name = "DESCRIPTION",columnDefinition = "text",nullable = false)
    @Lob
    private String description;
    @OneToOne@JoinColumn(name = "USER_FK")
    private User user;
    @Column(name = "SERVICE_DATE",columnDefinition = "timestamptz",nullable = false)
    private Date date;
    @Version
    private long recordControl;
    @Column(name = "STATE",columnDefinition = "text",nullable = false)
    private String state;



    public long getId() {
        return id;
    }

    public Service setId(long id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Service setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Service setDescription(String description) {
        this.description = description;
        return this;
    }

    public User getUser() {
        return user;
    }

    public Service setUser(User user) {
        this.user = user;
        return this;
    }

    public Date getDate() {
        return date;
    }

    public Service setDate(Date date) {
        this.date = date;
        return this;
    }

    public long getRecordControl() {
        return recordControl;
    }

    public Service setRecordControl(long recordControl) {
        this.recordControl = recordControl;
        return this;
    }

    public String getState() {
        return state;
    }

    public Service setState(String state) {
        this.state = state;
        return this;
    }


    @Override
    public String toString() {
        return "Service{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", user=" + user.toString() +
                ", date=" + date +
                ", recordControl=" + recordControl +
                ", state='" + state + '\'' +
                '}';
    }
}
