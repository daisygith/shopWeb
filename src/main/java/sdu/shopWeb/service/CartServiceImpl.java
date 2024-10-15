package sdu.shopWeb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sdu.shopWeb.dto.CartDTO;
import sdu.shopWeb.dto.ProductDTO;
import sdu.shopWeb.dto.UsersDTO;
import sdu.shopWeb.entity.Cart;
import sdu.shopWeb.entity.Product;
import sdu.shopWeb.entity.Users;
import sdu.shopWeb.repository.CartRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CartServiceImpl implements CartService{

    @Autowired
    private CartRepository cartRepository;

    @Override
    public List<CartDTO> findAllCarts() {
        List<Cart> cartList = cartRepository.findAll();

        List<CartDTO> cartListDTO = new ArrayList<>();

        cartList.forEach((Cart item) -> {
            cartListDTO.add(CartDTO.builder()
                            .id(item.getId())
                            .sumPrice(item.getSumPrice())
                    .build());
        });

        return cartListDTO;

    }

    @Override
    public CartDTO findById(Long cartId) throws Exception {

        Cart cart = cartRepository.findById(cartId).orElseThrow();

        CartDTO cartDTO = CartDTO.builder()
                .id(cart.getId())
                .sumPrice(cart.getSumPrice())
                .usersDTO(UsersDTO.builder()
                        .id(cart.getUsers().getId())
                        .name(cart.getUsers().getName())
                        .build())
                .productsDTO(cart.getProducts().stream()
                        .map(x -> ProductDTO.builder()
                                .id(x.getId())
                                .name(x.getName())
                                .price(x.getPrice())
                                .build()).collect(Collectors.toList()))
                .build();

        return cartDTO;
    }

    @Transactional
    @Override
    public CartDTO save(CartDTO cartDTO) {

        Cart cart = cartRepository.save(Cart.builder()
                        .id(cartDTO.getId())
                        .sumPrice(cartDTO.getSumPrice())
                        .users(Users.builder()
                                .id(cartDTO.getUsersDTO().getId())
                                .name(cartDTO.getUsersDTO().getName())
                                .build())
                        .products(cartDTO.getProductsDTO() != null ?
                                cartDTO.getProductsDTO().stream()
                                        .map(x -> Product.builder()
                                                .id(x.getId())
                                                .name(x.getName())
                                                .price(x.getPrice())
                                                .build()).collect(Collectors.toList()): null)
                .build());

        CartDTO cartListDTO = CartDTO.builder()
                .id(cart.getId())
                .sumPrice(cart.getSumPrice())
                .build();

        if(cart.getUsers() != null) {
            cartListDTO.setUsersDTO(UsersDTO.builder()
                    .id(cartDTO.getUsersDTO().getId())
                    .name(cartDTO.getUsersDTO().getName())
                    .build());
        }

        if(cart.getProducts() != null) {
            cartListDTO.setProductsDTO(cartDTO.getProductsDTO().stream()
                    .map(x-> ProductDTO.builder()
                            .id(x.getId())
                            .name(x.getName())
                            .price(x.getPrice())
                            .build()).collect(Collectors.toList()));
        }

        return cartListDTO;
    }

    @Transactional
    @Override
    public void deleteById(Long cartId) {
        cartRepository.deleteById(cartId);
    }
}
