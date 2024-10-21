package sdu.shopWeb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sdu.shopWeb.dto.CartDTO;
import sdu.shopWeb.dto.UsersDTO;
import sdu.shopWeb.entity.Cart;
import sdu.shopWeb.entity.Users;
import sdu.shopWeb.repository.UsersRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public List<UsersDTO> findAllUsers() {
        List<Users> usersList = usersRepository.findAll();

        List<UsersDTO> userListDTO = new ArrayList<>();

        usersList.forEach((Users item) -> {
            userListDTO.add(UsersDTO.builder()
                            .id(item.getId())
                            .name(item.getName())
                    .build());
        });
        return userListDTO;
    }

    @Override
    public UsersDTO findById(Long userId) throws Exception {

        Users users = usersRepository.findById(userId).orElseThrow();

        UsersDTO usersDTO = UsersDTO.builder()
                .id(users.getId())
                .name(users.getName())
                .cartDTO(users.getCart() != null ? CartDTO.builder()
                        .id(users.getCart().getId())
                        .sumPrice(users.getCart().getSumPrice())
                        .build() : null)
                .build();


        return usersDTO;
    }

    @Transactional
    @Override
    public UsersDTO save(UsersDTO usersDTO) {

        Users users = usersRepository.save(Users.builder()
                        .id(usersDTO.getId())
                        .name(usersDTO.getName())
                        .cart(usersDTO.getCartDTO() != null ? Cart.builder()
                                .id(usersDTO.getCartDTO().getId())
                                .sumPrice(usersDTO.getCartDTO().getSumPrice())
                                .build() : Cart.builder().sumPrice(0d).build())
                .build());

        UsersDTO userListDTO = UsersDTO.builder()
                .id(users.getId())
                .name(users.getName())
                .build();

        if(users.getCart() != null){
            userListDTO.setCartDTO(CartDTO.builder()
                            .id(users.getCart().getId())
                            .sumPrice(users.getCart().getSumPrice())
                    .build());
        }

        return userListDTO;
    }

    @Transactional
    @Override
    public void deleteById(Long userId) {
        usersRepository.deleteById(userId);
    }
}
