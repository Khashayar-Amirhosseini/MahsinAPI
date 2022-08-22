package com.MahSinApi.model.entity;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "LIKES")
public class Like {
    @Id@GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "LIKE_DATE",columnDefinition = "DATE")
    private Date date;
    @OneToOne@JoinColumn(name = "USER_FK")
    private User user;
    @OneToOne@JoinColumn(name = "DOCTOR_FK")
    private Doctor doctor;
    @OneToOne@JoinColumn(name = "POST_FK")
    private Post post;

    @Column(name = "ACTION",columnDefinition = "text")
    private String action;

    @Version
    private long recordControl;

    public long getId() {
        return id;
    }

    public Like setId(long id) {
        this.id = id;
        return this;
    }

    public User getUser() {
        return user;
    }

    public Like setUser(User user) {
        this.user = user;
        return this;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public Like setDoctor(Doctor doctor) {
        this.doctor = doctor;
        return this;
    }

    public Date getDate() {
        return date;
    }

    public Like setDate(Date date) {
        this.date = date;
        return this;
    }

    public String getAction() {
        return action;
    }

    public Like setAction(String action) {
        this.action = action;
        return this;
    }

    public long getRecordControl() {
        return recordControl;
    }

    public Like setRecordControl(long recordControl) {
        this.recordControl = recordControl;
        return this;
    }

    public Post getPost() {
        return post;
    }

    public Like setPost(Post post) {
        this.post = post;
        return this;
    }

    public String toStringDoctor() {
        return "Like{" +
                "id=" + id +
                ", date=" + date +
                ", user=" + user +
                ", doctor=" + doctor.toString() +
                ", action='" + action + '\'' +
                ", recordControl=" + recordControl +
                '}';
    }
    public String toStringPost() {
        return "Like{" +
                "id=" + id +
                ", date=" + date +
                ", user=" + user +
                ", post=" + post.toString() +
                ", action='" + action + '\'' +
                ", recordControl=" + recordControl +
                '}';
    }

}
