package com.chapter4.chapter4.Controller;

import com.chapter4.chapter4.DTO.ScedulesDTO;
import com.chapter4.chapter4.DTO.SeatsDTO;
import com.chapter4.chapter4.Model.Scedules;
import com.chapter4.chapter4.Model.Seats;
import com.chapter4.chapter4.Service.SeatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/seats")
public class SeatsController {
    @Autowired
    SeatsService seatsService;


    @PostMapping("/add/{seatsId}")
    public SeatsDTO addSeatsToScedules(@PathVariable Long seatsId, @RequestBody SeatsDTO request){
        final Seats seats = seatsService.mapToEntity(request);
        final Seats result = seatsService.addSeats(seatsId, seats);
        return seatsService.mapToDto(result);
    }

    @PutMapping("/update/{seatsId}")
    public SeatsDTO update(@PathVariable Long seatsId, @RequestBody SeatsDTO request ){
        final Seats seats = seatsService.mapToEntity(request);
        final Seats result = seatsService.update(seatsId, seats);
        return seatsService.mapToDto(result);
    }

    @DeleteMapping("/delete/{seatsId}")
    public Boolean delete(@PathVariable Long seatsId) {
        return seatsService.delete(seatsId);
    }
}

