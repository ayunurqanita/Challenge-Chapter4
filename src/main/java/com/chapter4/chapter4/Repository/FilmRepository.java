package com.chapter4.chapter4.Repository;

import com.chapter4.chapter4.Model.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FilmRepository extends JpaRepository <Film, Long>{

    @Query("SELECT f FROM Film f WHERE f.tayang_atau_tidak = 'Sedang Tayang'")
    List<Film> findByTayangAtauTidak(String sedangTayang);

}
