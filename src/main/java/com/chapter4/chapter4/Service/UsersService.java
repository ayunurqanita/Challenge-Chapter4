package com.chapter4.chapter4.Service;


import com.chapter4.chapter4.DTO.UsersDTO;
import com.chapter4.chapter4.Model.Users;

public interface UsersService {

    Users findById(Integer id);

    Users mapToEntity(UsersDTO usersDTO);

    UsersDTO mapToDto(Users users);

    Users addUsers(Long scedulesId, Users users);

    Users update(Integer id, Users users);

    Boolean delete(Integer id);

}
