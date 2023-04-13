package com.chapter4.chapter4.DTO;

import java.util.List;

public record FilmDTO(Long id, String film_code, String film_name, String tayang_atau_tidak, List<ScedulesDTO> sceduless) {
}
