package com.chapter4.chapter4.Controller;

import com.chapter4.chapter4.DTO.UsersDTO;
import com.chapter4.chapter4.Model.Users;
import com.chapter4.chapter4.Service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    UsersService usersService;


    @PostMapping("/add/{seatsId}")
    public UsersDTO addUsersToFilm(@PathVariable Long seatsId, @RequestBody UsersDTO request){
        final Users users = usersService.mapToEntity(request);
        final Users result = usersService.addUsers(seatsId, users);
        return usersService.mapToDto(result);
    }

    @PutMapping("/update/{usersId}")
    public UsersDTO update(@PathVariable Integer usersId, @RequestBody UsersDTO request ){
        final Users users = usersService.mapToEntity(request);
        final Users result = usersService.update(usersId, users);
        return usersService.mapToDto(result);
    }

    @DeleteMapping("/delete/{usersId}")
    public Boolean delete(@PathVariable Integer usersId) {
        return usersService.delete(usersId);
    }
}
