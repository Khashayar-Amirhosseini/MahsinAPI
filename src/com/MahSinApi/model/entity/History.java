package com.MahSinApi.model.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity(name = "HISTORY")
public class History {
    @Id@GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    @Lob
    //@NotNull@Column(unique = true,name="DESCRIPTION",columnDefinition = "BLOB")
    @NotNull@Column(name="DESCRIPTION",columnDefinition = "TEXT")
    private String description;
    @Column(name = "UPDATE_DATE", columnDefinition = "DATE")
    private Date Date;
    @OneToOne@JoinColumn(name = "USER_FK")
    private User user;
    @Version
    private long recordControl;



    public long getId() {
        return id;
    }

    public History setId(long id) {
        this.id = id;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public History setDescription(String description) {
        this.description = description;
        return this;
    }

    public java.util.Date getDate() {
        return Date;
    }

    public History setDate(java.util.Date date) {
        Date = date;
        return this;
    }

    public User getUser() {
        return user;
    }

    public History setUser(User user) {
        this.user = user;
        return this;
    }

    public long getRecordControl() {
        return recordControl;
    }

    public History setRecordControl(long recordControl) {
        this.recordControl = recordControl;
        return this;
    }

    @Override
    public String toString() {
        return "History{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", Date=" + Date +
                ", user=" + user.toString() +
                '}';
    }
}
