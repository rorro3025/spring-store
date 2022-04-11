package com.unam.store.models;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlSchemaType;
import java.sql.Timestamp;

@Entity
@Table(name= "users")
public class User {
    @Getter @Setter @Id @Column(name="id")
    private long id;
    @Getter @Setter @Column(name="name")
    private String name;
    @Getter @Setter @Column(name = "email")
    private String email;
    @Getter @Setter @Column(name = "password")
    private String password;
    @Getter @Setter @Column(name = "created_at") @CreationTimestamp
    private Timestamp createdAt;

    /*public User (long id,String name,String email,String password, String createdAt) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.createdAt = createdAt;
    }*/
}
