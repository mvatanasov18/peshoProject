package com.example.boilerplate.models;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "Receptionists")
public class Receptionist {
    @Id
    @Column(name = "Id",nullable = false,columnDefinition = "varchar(36")
    private String id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "UserId",unique = true,referencedColumnName = "Id",columnDefinition ="varchar(36)")
    private User user;
    public Receptionist(){

        this.id= UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
