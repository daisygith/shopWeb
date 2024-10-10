package sdu.shopWeb.service;

import sdu.shopWeb.dto.CartDTO;

import java.util.List;

public interface CartService {

    List<CartDTO> findAllCarts();

    CartDTO findById(Long theId) throws Exception;

    CartDTO save(CartDTO cartDTO);

    void deleteById(Long theId);


}
