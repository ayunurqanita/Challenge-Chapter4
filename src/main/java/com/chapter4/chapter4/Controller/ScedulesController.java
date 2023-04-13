package com.chapter4.chapter4.Controller;

import com.chapter4.chapter4.DTO.ScedulesDTO;
import com.chapter4.chapter4.Model.Scedules;
import com.chapter4.chapter4.Service.ScedulesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/scedules")
public class ScedulesController {

    @Autowired
    ScedulesService scedulesService;

    @PostMapping("/add/{filmId}")
    public ScedulesDTO addUsersToFilm(@PathVariable Long filmId, @RequestBody ScedulesDTO request){
        final Scedules scedules = scedulesService.mapToEntity(request);
        final Scedules result = scedulesService.addScedules(filmId, scedules);
        return scedulesService.mapToDto(result);
    }

    @PutMapping("/update/{scedulesId}")
    public ScedulesDTO update(@PathVariable Long scedulesId, @RequestBody ScedulesDTO request ){
        final Scedules scedules = scedulesService.mapToEntity(request);
        final Scedules result = scedulesService.update(scedulesId, scedules);
        return scedulesService.mapToDto(result);
    }

    @DeleteMapping("/delete/{scedulesId}")
    public Boolean delete(@PathVariable Long scedulesId) {
        return scedulesService.delete(scedulesId);
    }


}
