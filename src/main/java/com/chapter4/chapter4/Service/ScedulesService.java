package com.chapter4.chapter4.Service;

import com.chapter4.chapter4.DTO.ScedulesDTO;
import com.chapter4.chapter4.Model.Film;
import com.chapter4.chapter4.Model.Scedules;

public interface ScedulesService {

    Scedules addScedules (Long filmId, Scedules scedules);

    Scedules mapToEntity(ScedulesDTO scedulesDTO);

    ScedulesDTO mapToDto(Scedules scedules);

    Scedules findById(Long id);

    Boolean delete(Long id);

    Scedules update(Long id, Scedules scedules);

    Scedules create(Scedules scedules);
}
