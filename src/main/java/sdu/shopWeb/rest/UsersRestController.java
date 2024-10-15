package sdu.shopWeb.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sdu.shopWeb.dto.UsersDTO;
import sdu.shopWeb.service.UsersService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UsersRestController {

    @Autowired
    UsersService usersService;

    @GetMapping("/users")
    public List<UsersDTO> findAllUser(){
        return usersService.findAllUsers();
    }

    @GetMapping("/users/{userId}")
    public UsersDTO getUser(@PathVariable Long userId) throws Exception{
        UsersDTO usersDTO = usersService.findById(userId);

        return usersDTO;
    }

    @PostMapping("/users")
    public UsersDTO addUser(@RequestBody UsersDTO usersDTO) {
        UsersDTO dbUser = usersService.save(usersDTO);

        return dbUser;
    }

    @PutMapping("/users")
    public UsersDTO updateUser(@RequestBody UsersDTO usersDTO){
        UsersDTO dbUser = usersService.save(usersDTO);

        return dbUser;
    }

    @DeleteMapping("/users/{userId}")
    public String deleteUser(@PathVariable Long userId) throws Exception {

        UsersDTO tempUser = usersService.findById(userId);

        if(tempUser == null) {
            throw new RuntimeException("User is not found - " + userId);
        }

        usersService.deleteById(userId);

        return "Delete user id - " + userId;

    }
}
