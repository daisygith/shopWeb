package sdu.shopWeb.service;

import sdu.shopWeb.dto.UsersDTO;

import java.util.List;

public interface UsersService {

    List<UsersDTO> findAllUsers();

    UsersDTO findById(Long userId) throws Exception;

    UsersDTO save(UsersDTO usersDTO);

    void deleteById(Long userId);

}
