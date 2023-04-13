package com.chapter4.chapter4.DTO;

import java.sql.Time;
import java.util.Date;
import java.util.List;

public record ScedulesDTO(int scedules_id, String film_code, Date tanggal_tayang, Time jam_mulai, Time jam_selesai, Double harga_tiket, List<SeatsDTO> seatss) {
}
