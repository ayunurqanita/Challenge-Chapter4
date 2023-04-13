package com.chapter4.chapter4.Service;

import com.chapter4.chapter4.DTO.UsersDTO;
import com.chapter4.chapter4.Model.Film;
import com.chapter4.chapter4.Model.Seats;
import com.chapter4.chapter4.Model.Users;
import com.chapter4.chapter4.Repository.UsersRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UsersServiceImpl implements UsersService{

    ObjectMapper mapper = new ObjectMapper();

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    SeatsService seatsService;

    @Override
    public Users addUsers(Long seatsId, Users users){
        final Seats seats = seatsService.findById(seatsId);
        if(seats != null){
            // add store to db
            users = usersRepository.save(users);
            if (seats.getUserss() != null){
                List<Users> userss = seats.getUserss();
                userss.add(users);
                seats.setUserss(userss);
            }else {
                seats.setUserss(Collections.singletonList(users));
            }
            seatsService.create(seats);
            return users;
        }
        return null;
    }

    @Override
    public Users update(Integer id, Users users) {
        Users result = findById(id);
        if (result != null) {
            result.setUsername(users.getUsername());
            result.setEmail_address(users.getEmail_address());
            result.setPassword(users.getPassword());
            return usersRepository.save(result);
        }
        return null;
    }

    @Override
    public Boolean delete(Integer id) {
        final Users result = findById(id);
        if (result != null) {
            usersRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Users findById(Integer id) {
        Optional<Users> result = usersRepository.findById(id);
        if (result.isPresent()) {
            return result.get();
        }
        return null;
    }

    @Override
    public Users mapToEntity (UsersDTO usersDTO){
        return mapper.convertValue(usersDTO, Users.class);
    }

    @Override
    public UsersDTO mapToDto(Users users){
        return mapper.convertValue(users, UsersDTO.class);
    }
}
