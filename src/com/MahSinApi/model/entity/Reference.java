package com.MahSinApi.model.entity;

import javax.persistence.*;

@Entity(name = "POST_REFERENCES")
public class Reference {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Lob
    //@Column(name = "VALUE",columnDefinition = "clob",nullable = false)
    @Column(name = "DIS",columnDefinition = "text",nullable = false)
    private String value;

    public long getId() {
        return id;
    }

    public Reference setId(long id) {
        this.id = id;
        return this;
    }

    public String getValue() {
        return value;
    }

    public Reference setValue(String value) {
        this.value = value;
        return this;
    }

    @Override
    public String toString() {
        return "Reference{" +
                "id=" + id +
                ", value='" + value + '\'' +
                '}';
    }
}
