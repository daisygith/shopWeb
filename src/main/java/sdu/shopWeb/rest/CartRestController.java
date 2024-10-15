package sdu.shopWeb.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sdu.shopWeb.dto.CartDTO;
import sdu.shopWeb.service.CartService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CartRestController {

    @Autowired
    CartService cartService;

    @GetMapping("/cart")
    public List<CartDTO> findAllCarts(){

        return cartService.findAllCarts();
    }

    @GetMapping("/cart/{cartId}")
    public CartDTO getCart(@PathVariable Long cartId) throws Exception{

        CartDTO cartDTO = cartService.findById(cartId);

        return cartDTO;
    }

    @PostMapping("/cart")
    public CartDTO addCart(@RequestBody CartDTO cartDTO){

        CartDTO dbCart = cartService.save(cartDTO);

        return dbCart;

    }

    @PutMapping("/cart")
    public CartDTO updateCar(@RequestBody CartDTO cartDTO){

        CartDTO dbCart = cartService.save(cartDTO);

        return dbCart;
    }

    @DeleteMapping("cart/{cartId}")
    public String deleteCart(@PathVariable Long cartId) throws Exception{

        CartDTO tempCart = cartService.findById(cartId);

        if(tempCart == null){
            throw new RuntimeException("Cart is not found - " + cartId);
        }

        cartService.deleteById(cartId);

        return "Delete cart id - " + cartId;
    }
}
