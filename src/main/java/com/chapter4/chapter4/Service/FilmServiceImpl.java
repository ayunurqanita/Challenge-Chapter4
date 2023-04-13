package com.chapter4.chapter4.Service;

import com.chapter4.chapter4.DTO.FilmDTO;
import com.chapter4.chapter4.Model.Film;
import com.chapter4.chapter4.Repository.FilmRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class FilmServiceImpl implements FilmService {

    @Autowired
    FilmRepository filmRepository;

    ObjectMapper mapper = new ObjectMapper();

    @Override
    public Film create (Film film) {
        final Film result = filmRepository.save(film);
        return result;
    }

    @Override
    public Film update (Long id, Film film) {
        Film result = findById(id);
        if (result != null) {
            result.setFilm_code(film.getFilm_code());
            result.setFilm_name(film.getFilm_name());
            result.setTayang_atau_tidak(film.getTayang_atau_tidak());
            return filmRepository.save(result);
        }
        return null;
    }

    @Override
    public Boolean delete (Long id) {
        final Film result = findById(id);
        if (result != null) {
            filmRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<Film> findAll(){
        return filmRepository.findAll();
    }

    @Override
    public Film findById(Long id) {
        Optional<Film> result = filmRepository.findById(id);
        if (result.isPresent()) {
            return result.get();
        }
        return null;
    }

    @Override
    public FilmDTO mapToDto(Film film){
        return mapper.convertValue(film, FilmDTO.class);
    }

    @Override
    public Film mapToEntity(FilmDTO filmDTO){
        return mapper.convertValue(filmDTO, Film.class);
    }

    @Override
    public List<Film> findShowingFilms() {
        return filmRepository.findByTayangAtauTidak("Sedang Tayang");
    }
}
