package sdu.shopWeb.service;

import sdu.shopWeb.dto.UserDTO;

import java.util.List;

public interface UserService {

    List<UserDTO> findAllUsers();

    UserDTO findById(Long userId) throws Exception;

    UserDTO save(UserDTO userDTO);

    void deleteById(Long userId);

}
