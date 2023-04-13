package com.chapter4.chapter4.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "seats")
public class Seats {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer seats_id;

    @Column (name = "Nomor_Kursi")
    private Integer nomor_kursi;

    @Column (name = "Studio_Name")
    private String studio_name;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "users")
    private List<Users> userss;
}

