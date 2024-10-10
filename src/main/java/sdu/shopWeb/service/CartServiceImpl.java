package sdu.shopWeb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sdu.shopWeb.dto.CartDTO;
import sdu.shopWeb.repository.CartRepository;

import java.util.List;

@Service
public class CartServiceImpl implements CartService{

    @Autowired
    private CartRepository cartRepository;

    @Override
    public List<CartDTO> findAllCarts() {
        return null;
    }

    @Override
    public CartDTO findById(Long theId) throws Exception {
        return null;
    }

    @Override
    public CartDTO save(CartDTO cartDTO) {
        return null;
    }

    @Override
    public void deleteById(Long theId) {

    }
}
