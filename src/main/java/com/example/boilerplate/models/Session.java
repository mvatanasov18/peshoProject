package com.example.boilerplate.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.UUID;

@ToString
@EqualsAndHashCode
@Entity
@AllArgsConstructor
@Table(name = "Sessions")
public class Session {
    @Id
    @Column(name = "Id",nullable = false,columnDefinition = "varchar(36)")
    private String id;

    @Column(name = "RoleName",nullable = false,columnDefinition = "varchar(20)")
    private String roleName;

    @Column(name = "TimeCreated",nullable = false,columnDefinition = "datetime(0)")
    private Timestamp timeCreated;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "UserId")
    private User user;

    public Session() {
        this.id= UUID.randomUUID().toString();
    }



    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Timestamp getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(Timestamp timeCreated) {
        this.timeCreated = timeCreated;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User userId) {
        this.user = userId;
    }
}
