package sdu.shopWeb.service;

import sdu.shopWeb.dto.UserDTO;

import java.util.List;

public interface UserService {

    List<UserDTO> findAllUsers();

    UserDTO findById(Long theId) throws Exception;

    UserDTO save(UserDTO theUserDTO);

    void deleteById(Long theId);

}
