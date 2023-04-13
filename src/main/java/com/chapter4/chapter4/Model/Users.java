package com.chapter4.chapter4.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer users_id;

    @Column (name = "username")
    private String username;

    @Column (name = "email_address")
    private String email_address;

    @Column (name = "password")
    private String password;


}
