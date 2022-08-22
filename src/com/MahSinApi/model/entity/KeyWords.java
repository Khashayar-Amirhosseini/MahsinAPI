package com.MahSinApi.model.entity;

import javax.persistence.*;

@Entity(name = "KEYWORDS")
public class KeyWords {
    @Id@GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "VALUE",columnDefinition = "text",nullable = false)
    private String value;

    public long getId() {
        return id;
    }

    public KeyWords setId(long id) {
        this.id = id;
        return this;
    }

    public String getValue() {
        return value;
    }

    public KeyWords setValue(String value) {
        this.value = value;
        return this;
    }
}
