package com.MahSinApi.model.entity;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "GOALS")
public class Goal {
    @Id@GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "DESCRIPTION",columnDefinition = "text",nullable = false)
    private String description;
    @Column(name = "STATE",columnDefinition = "text",nullable = false)
    private String state;
    @Version
    private long recordControl;
    @OneToOne@JoinColumn(name = "USER_FK")
    private User user;
    @Column(name = "GOAL_DATE",columnDefinition = "timestamptz",nullable = false)
    private Date date;

    public long getId() {
        return id;
    }

    public Goal setId(long id) {
        this.id = id;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Goal setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getState() {
        return state;
    }

    public Goal setState(String state) {
        this.state = state;
        return this;
    }

    public long getRecordControl() {
        return recordControl;
    }

    public Goal setRecordControl(long recordControl) {
        this.recordControl = recordControl;
        return this;
    }

    public User getUser() {
        return user;
    }

    public Goal setUser(User user) {
        this.user = user;
        return this;
    }

    public Date getDate() {
        return date;
    }

    public Goal setDate(Date date) {
        this.date = date;
        return this;
    }

    @Override
    public String toString() {
        return "Goal{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", state='" + state + '\'' +
                ", recordControl=" + recordControl +
                ", user=" + user.toString() +
                ", date=" + date +
                '}';
    }
}
