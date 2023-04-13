package com.chapter4.chapter4.Service;

import com.chapter4.chapter4.DTO.ScedulesDTO;
import com.chapter4.chapter4.Model.Film;
import com.chapter4.chapter4.Model.Scedules;
import com.chapter4.chapter4.Repository.ScedulesRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ScedulesServerImpl implements ScedulesService{

    ObjectMapper mapper = new ObjectMapper();

    @Autowired
    ScedulesRepository scedulesRepository;

    @Autowired
    FilmService filmService;

    @Override
    public Scedules addScedules(Long filmId, Scedules scedules){
        final Film film = filmService.findById(filmId);
        if(film != null){
            // add store to db
            scedules = scedulesRepository.save(scedules);
            if (film.getSceduless() != null){
                List<Scedules> sceduless = film.getSceduless();
                sceduless.add(scedules);
                film.setSceduless(sceduless);
            }else {
                film.setSceduless(Collections.singletonList(scedules));
            }
            filmService.create(film);
            return scedules;
        }
        return null;
    }

    @Override
    public Scedules findById(Long id) {
        Optional<Scedules> result = scedulesRepository.findById(Math.toIntExact(id));
        if (result.isPresent()) {
            return result.get();
        }
        return null;
    }

    @Override
    public Boolean delete(Long id) {
        final Scedules result = findById(id);
        if (result != null) {
            scedulesRepository.deleteById(Math.toIntExact(id));
            return true;
        }
        return false;
    }

    @Override
    public Scedules update(Long id, Scedules scedules) {
        Scedules result = findById(id);
        if (result != null) {
            result.setFilm_code(scedules.getFilm_code());
            result.setTanggal_tayang(scedules.getTanggal_tayang());
            result.setJam_mulai(scedules.getJam_mulai());
            return scedulesRepository.save(result);
        }
        return null;
    }

    @Override
    public Scedules create(Scedules scedules) {
        final Scedules result = scedulesRepository.save(scedules);
        return result;
    }

    @Override
    public Scedules mapToEntity (ScedulesDTO scedulesDTO){
        return mapper.convertValue(scedulesDTO, Scedules.class);
    }

    @Override
    public ScedulesDTO mapToDto(Scedules scedules){
        return mapper.convertValue(scedules, ScedulesDTO.class);
    }


}
