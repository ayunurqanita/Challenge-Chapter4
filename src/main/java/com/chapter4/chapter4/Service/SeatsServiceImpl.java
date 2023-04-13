package com.chapter4.chapter4.Service;

import com.chapter4.chapter4.DTO.SeatsDTO;
import com.chapter4.chapter4.Model.Scedules;
import com.chapter4.chapter4.Model.Seats;
import com.chapter4.chapter4.Repository.SeatsRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SeatsServiceImpl implements SeatsService {

    ObjectMapper mapper = new ObjectMapper();

    @Autowired
    SeatsRepository seatsRepository;

    @Autowired
    ScedulesService scedulesService;

    @Override
    public Seats mapToEntity(SeatsDTO seatsDTO) {
        return mapper.convertValue(seatsDTO, Seats.class);
    }

    @Override
    public SeatsDTO mapToDto(Seats seats) {
        return mapper.convertValue(seats, SeatsDTO.class);
    }

    @Override
    public Seats addSeats(Long scedulesId, Seats seats){
        final Scedules scedules = scedulesService.findById(scedulesId);
        if(scedules != null){
            // add store to db
            seats = seatsRepository.save(seats);
            if (scedules.getSeatss() != null){
                List<Seats> seatss = scedules.getSeatss();
                seatss.add(seats);
                scedules.setSeatss(seatss);
            }else {
                scedules.setSeatss(Collections.singletonList(seats));
            }
            scedulesService.create(scedules);
            return seats;
        }
        return null;
    }

    @Override
    public Seats findById(Long id) {
        Optional<Seats> result = seatsRepository.findById(Math.toIntExact(id));
        if (result.isPresent()) {
            return result.get();
        }
        return null;
    }

    @Override
    public Seats create(Seats seats) {
        final Seats result = seatsRepository.save(seats);
        return result;
    }

    @Override
    public Seats update(Long id, Seats seats) {
        Seats result = findById(id);
        if (result != null) {
            result.setNomor_kursi(seats.getNomor_kursi());
            result.setStudio_name(seats.getStudio_name());
            return seatsRepository.save(result);
        }
        return null;
    }

    @Override
    public Boolean delete(Long id) {
        final Seats result = findById(id);
        if (result != null) {
            seatsRepository.deleteById(Math.toIntExact(id));
            return true;
        }
        return false;
    }

}
