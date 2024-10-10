package sdu.shopWeb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sdu.shopWeb.dto.UserDTO;
import sdu.shopWeb.repository.UserRepository;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserDTO> findAllUsers() {
        return null;
    }

    @Override
    public UserDTO findById(Long theId) throws Exception {
        return null;
    }

    @Override
    public UserDTO save(UserDTO theUserDTO) {
        return null;
    }

    @Override
    public void deleteById(Long theId) {

    }
}
