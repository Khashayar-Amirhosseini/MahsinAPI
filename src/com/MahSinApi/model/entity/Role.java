package com.MahSinApi.model.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity(name="ROLE")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotNull
    @Column(unique = true,columnDefinition = "text",name = "ROLE_NAME")
    private String roleName;

    @Version
    private long recordControl;





    public long getId() {
        return id;
    }

    public Role setId(long id) {
        this.id = id;
        return this;
    }

    public String getRoleName() {
        return roleName;
    }

    public Role setRoleName(String roleName) {
        this.roleName = roleName;
        return this;
    }

    public long getRecordControl() {
        return recordControl;
    }

    public Role setRecordControl(long recordControl) {
        this.recordControl = recordControl;
        return this;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                '}';
    }
}
