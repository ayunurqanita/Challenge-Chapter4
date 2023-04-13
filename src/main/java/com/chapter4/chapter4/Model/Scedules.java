package com.chapter4.chapter4.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "scedules")
public class Scedules {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int scedules_id;

    @Column (name = "Film_Code")
    private String film_code;

    @Column (name = "Tanggal_Tayang")
    private Date tanggal_tayang;

    @Column (name = "Jam_Mulai")
    private Time jam_mulai;

    @Column (name = "Jam_Selesai")
    private Time jam_selesai;

    @Column (name = "Harga_Tiket")
    private Double harga_tiket;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "seats")
    private List<Seats> seatss;
}
