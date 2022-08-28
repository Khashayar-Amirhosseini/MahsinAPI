package com.MahSinApi.model.entity;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "ACHIEVEMENTS")
public class Achievement {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    //@Lob@Column(name = "DESCRIPTION",columnDefinition = "CLOB",nullable = false,unique = true)
    @Column(name = "DESCRIPTION",columnDefinition = "TEXT",nullable = false)
    private String description;
    @Column(name = "ACHIEVEMENT_DATE",columnDefinition = "timestamptz")
    private Date date;
    @Column(name="STATE",columnDefinition = "TEXT")
    private String state;
    @OneToOne@JoinColumn(name = "USER_FK")
    private User user;

    @Version
    private long recordControl;

    public String getDescription() {
        return description;
    }

    public Achievement setDescription(String description) {
        this.description = description;
        return this;
    }

    public Date getDate() {
        return date;
    }

    public Achievement setDate(Date date) {
        this.date = date;
        return this;
    }

    public String getState() {
        return state;
    }

    public Achievement setState(String state) {
        this.state = state;
        return this;
    }

    public User getUser() {
        return user;
    }

    public Achievement setUser(User user) {
        this.user = user;
        return this;
    }

    public long getId() {
        return id;
    }

    public Achievement setId(long id) {
        this.id = id;
        return this;
    }

    public long getRecordControl() {
        return recordControl;
    }

    public Achievement setRecordControl(long recordControl) {
        this.recordControl = recordControl;
        return this;
    }

    @Override
    public String toString() {
        return "Achievements{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", Date=" + date +
                ", state='" + state + '\'' +
                ", user=" + user.toString() +
                '}';
    }
}
