package com.chapter4.chapter4.Service;

import com.chapter4.chapter4.DTO.SeatsDTO;
import com.chapter4.chapter4.Model.Scedules;
import com.chapter4.chapter4.Model.Seats;

public interface SeatsService {
    Seats mapToEntity(SeatsDTO seatsDTO);

    SeatsDTO mapToDto(Seats seats);

    Seats addSeats(Long scedulesId, Seats seats);

    Seats findById(Long id);

    Seats create(Seats seats);

    Seats update(Long id, Seats seats);

    Boolean delete(Long id);

}
