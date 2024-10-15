package sdu.shopWeb.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sdu.shopWeb.dto.ProductDTO;
import sdu.shopWeb.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductRestController {

    @Autowired
    ProductService productService;

    @GetMapping("/product")
    public List<ProductDTO> findAllProducts(){
        return productService.findAllProducts();
    }

    @GetMapping("/product/{productId}")
    public ProductDTO getProduct(@PathVariable Long productId) throws Exception {
        ProductDTO productDTO = productService.findById(productId);

        return productDTO;
    }

    @PostMapping("/product")
    public ProductDTO addProduct(@RequestBody ProductDTO productDTO){
        ProductDTO dbProduct = productService.save(productDTO);

        return dbProduct;
    }

    @PutMapping("/product")
    public ProductDTO updateProduct(@RequestBody ProductDTO productDTO){
        ProductDTO dbProduct = productService.save(productDTO);

        return dbProduct;
    }

    @DeleteMapping("/product/{productId}")
    public String deleteProduct(@PathVariable Long productId) throws Exception{

        ProductDTO tempProduct = productService.findById(productId);

        if(tempProduct == null){
            throw new RuntimeException("Product is not found - " + productId);
        }

        productService.deleteById(productId);

        return "Delete product id - " + productId;

    }



}
