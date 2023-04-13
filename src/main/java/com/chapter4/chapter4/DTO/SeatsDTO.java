package com.chapter4.chapter4.DTO;

import java.util.List;

public record SeatsDTO(Integer seats_id, Integer nomor_kursi, String studio_name, List<UsersDTO> userss) {
}
