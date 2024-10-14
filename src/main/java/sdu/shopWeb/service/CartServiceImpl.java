package sdu.shopWeb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sdu.shopWeb.dto.CartDTO;
import sdu.shopWeb.dto.ProductDTO;
import sdu.shopWeb.dto.UserDTO;
import sdu.shopWeb.entity.Cart;
import sdu.shopWeb.entity.Product;
import sdu.shopWeb.entity.User;
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
                .userDTO(UserDTO.builder()
                        .id(cart.getUser().getId())
                        .name(cart.getUser().getName())
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
                        .user(User.builder()
                                .id(cartDTO.getUserDTO().getId())
                                .name(cartDTO.getUserDTO().getName())
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

        if(cart.getUser() != null) {
            cartListDTO.setUserDTO(UserDTO.builder()
                    .id(cartDTO.getUserDTO().getId())
                    .name(cartDTO.getUserDTO().getName())
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
