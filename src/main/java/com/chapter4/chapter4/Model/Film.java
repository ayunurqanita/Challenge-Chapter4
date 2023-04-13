package com.chapter4.chapter4.Model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "film")
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "Film_Code")
    private String film_code;

    @Column (name = "Film_Name")
    private String film_name;

    @Column (name = "Tayang_atau_Tidak")
    private String tayang_atau_tidak;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "scedules")
    private List<Scedules> sceduless;

}
