package com.MahSinApi.model.entity;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "POLICIES")
public class Policy {
    @Id@GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    //@Column(name = "DESCRIPTION",columnDefinition = "CLOB",nullable = false,unique = true)
    @Column(name = "DESCRIPTION",columnDefinition = "text",nullable = false)
    private String description;
    @Column(name = "STATE",columnDefinition = "text",nullable = false)
    private String state;
    @Version
    private long recordControl;
    @OneToOne@JoinColumn(name = "USER_FK")
    private User user;
    @Column(name = "POLICY_DATE",columnDefinition = "timestamptz",nullable = false)
    private Date date;

    public long getId() {
        return id;
    }

    public Policy setId(long id) {
        this.id = id;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Policy setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getState() {
        return state;
    }

    public Policy setState(String state) {
        this.state = state;
        return this;
    }

    public long getRecordControl() {
        return recordControl;
    }

    public Policy setRecordControl(long recordControl) {
        this.recordControl = recordControl;
        return this;
    }

    public User getUser() {
        return user;
    }

    public Policy setUser(User user) {
        this.user = user;
        return this;
    }

    public Date getDate() {
        return date;
    }

    public Policy setDate(Date date) {
        this.date = date;
        return this;
    }

    @Override
    public String toString() {
        return "Policies{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", state='" + state + '\'' +
                ", recordControl=" + recordControl +
                ", user=" + user.toString() +
                ", date=" + date +
                '}';
    }
}
