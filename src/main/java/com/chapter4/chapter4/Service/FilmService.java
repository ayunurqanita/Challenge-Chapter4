package com.chapter4.chapter4.Service;

import com.chapter4.chapter4.DTO.FilmDTO;
import com.chapter4.chapter4.Model.Film;

import java.util.List;

public interface FilmService {

    Film create(Film film);

    Film update(Long id, Film film);

    Boolean delete(Long id);

    List<Film> findAll();

    Film findById(Long id);

    FilmDTO mapToDto(Film film);

    Film mapToEntity(FilmDTO filmDTO);

    List<Film> findShowingFilms();
}
