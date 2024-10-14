package sdu.shopWeb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sdu.shopWeb.dto.CartDTO;
import sdu.shopWeb.dto.UserDTO;
import sdu.shopWeb.entity.Cart;
import sdu.shopWeb.entity.User;
import sdu.shopWeb.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserDTO> findAllUsers() {
        List<User> userList = userRepository.findAll();

        List<UserDTO> userListDTO = new ArrayList<>();

        userList.forEach((User item) -> {
            userListDTO.add(UserDTO.builder()
                            .id(item.getId())
                            .name(item.getName())
                    .build());
        });
        return userListDTO;
    }

    @Override
    public UserDTO findById(Long userId) throws Exception {

        User user = userRepository.findById(userId).orElseThrow();

        UserDTO userDTO = UserDTO.builder()
                .id(user.getId())
                .name(user.getName())
                .cartDTO(CartDTO.builder()
                        .id(user.getCart().getId())
                        .sumPrice(user.getCart().getSumPrice())
                        .build())
                .build();


        return userDTO;
    }

    @Transactional
    @Override
    public UserDTO save(UserDTO userDTO) {

        User user = userRepository.save(User.builder()
                        .id(userDTO.getId())
                        .name(userDTO.getName())
                        .cart(Cart.builder()
                                .id(userDTO.getCartDTO().getId())
                                .sumPrice(userDTO.getCartDTO().getSumPrice())
                                .build())
                .build());

        UserDTO userListDTO = UserDTO.builder()
                .id(user.getId())
                .name(user.getName())
                .build();

        if(user.getCart() != null){
            userListDTO.setCartDTO(CartDTO.builder()
                            .id(userDTO.getCartDTO().getId())
                            .sumPrice(userDTO.getCartDTO().getSumPrice())
                    .build());
        }

        return userListDTO;
    }

    @Transactional
    @Override
    public void deleteById(Long userId) {
        userRepository.deleteById(userId);
    }
}
