package com.MahSinApi.model.entity;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "Picture")
public class Picture {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "STATE",columnDefinition = "text",nullable = false)
    private String state;
    @Version
    private long recordControl;
    @OneToOne@JoinColumn(name = "USER_FK")
    private User user;
    @Column(name = "PICTURE_DATE",columnDefinition = "timestamptz",nullable = false)
    private Date date;

    public long getId() {
        return id;
    }

    public Picture setId(long id) {
        this.id = id;
        return this;
    }

    public String getState() {
        return state;
    }

    public Picture setState(String state) {
        this.state = state;
        return this;
    }

    public long getRecordControl() {
        return recordControl;
    }

    public Picture setRecordControl(long recordControl) {
        this.recordControl = recordControl;
        return this;
    }

    public User getUser() {
        return user;
    }

    public Picture setUser(User user) {
        this.user = user;
        return this;
    }

    public Date getDate() {
        return date;
    }

    public Picture setDate(Date date) {
        this.date = date;
        return this;
    }

    @Override
    public String toString() {
        return "Picture{" +
                "id=" + id +
                ", state='" + state + '\'' +
                ", recordControl=" + recordControl +
                ", user=" + user.toString() +
                ", date=" + date +
                '}';
    }
}
