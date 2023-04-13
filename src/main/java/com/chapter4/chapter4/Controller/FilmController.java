package com.chapter4.chapter4.Controller;


import com.chapter4.chapter4.DTO.FilmDTO;
import com.chapter4.chapter4.Model.Film;
import com.chapter4.chapter4.Service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/film")
public class FilmController {

    @Autowired
    FilmService filmService;

    @PostMapping("/create")
    public FilmDTO create(@RequestBody FilmDTO request ){
        final Film film = filmService.mapToEntity(request);
        final Film result = filmService.create(film);
        return filmService.mapToDto(result);
    }

    @PutMapping("/update/{id}")
    public FilmDTO update(@PathVariable Long id, @RequestBody FilmDTO request ){
        final Film film = filmService.mapToEntity(request);
        final Film result = filmService.update(id, film);
        return filmService.mapToDto(result);
    }

    @GetMapping("/all")
    public List<FilmDTO> findAll() {
        return filmService.findAll().stream()
                .map(film -> filmService.mapToDto(film))
                .collect(Collectors.toList());
    }

    @DeleteMapping("/delete/{id}")
    public Boolean delete(@PathVariable Long id) {
        return filmService.delete(id);
    }

    @GetMapping("/showing")
    public List<FilmDTO> findShowingFilms() {
        return filmService.findShowingFilms().stream()
                .map(film -> filmService.mapToDto(film))
                .collect(Collectors.toList());
    }

    @GetMapping("/film/{id}")
    public ResponseEntity<Film> getFilmById(@PathVariable Long id) {
        Film film = filmService.findById(id);
        if (film != null) {
            return ResponseEntity.ok().body(film);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
