package com.MahSinApi.model.entity;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity(name = "MAIN_SERVICES")
public class MainService {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "TITLE",columnDefinition = "text",nullable = false)
    private String title;
    //@Column(name = "DESCRIPTION",columnDefinition = "CLOP",nullable = false)
    @Column(name = "DESCRIPTION",columnDefinition = "text",nullable = false)
    @Lob
    private String description;
    @OneToOne@JoinColumn(name = "USER_FK")
    private User user;
    @Column(name = "MAIN_SERVICE_DATE",columnDefinition = "timestamptz",nullable = false)
    private Date date;
    @Version
    private long recordControl;
    @Column(name = "STATE",columnDefinition = "text",nullable = false)
    private String state;
    @OneToMany(cascade = CascadeType.ALL)@JoinColumn(name = "MAIN_SERVICE_FK")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Service> services;

    public long getId() {
        return id;
    }

    public MainService setId(long id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public MainService setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public MainService setDescription(String description) {
        this.description = description;
        return this;
    }

    public User getUser() {
        return user;
    }

    public MainService setUser(User user) {
        this.user = user;
        return this;
    }

    public Date getDate() {
        return date;
    }

    public MainService setDate(Date date) {
        this.date = date;
        return this;
    }

    public long getRecordControl() {
        return recordControl;
    }

    public MainService setRecordControl(long recordControl) {
        this.recordControl = recordControl;
        return this;
    }

    public String getState() {
        return state;
    }

    public MainService setState(String state) {
        this.state = state;
        return this;
    }

    public List<Service> getServices() {
        return services;
    }

    public MainService setServices(List<Service> services) {
        this.services = services;
        return this;
    }

    @Override
    public String toString() {
        return "MainService{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", user=" + user +
                ", date=" + date +
                ", recordControl=" + recordControl +
                ", state='" + state + '\'' +
                '}';
    }
}
