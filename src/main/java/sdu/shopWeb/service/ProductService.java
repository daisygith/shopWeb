package sdu.shopWeb.service;

import sdu.shopWeb.dto.ProductDTO;

import java.util.List;

public interface ProductService {

    List<ProductDTO> findAllProducts();

    ProductDTO findById(Long theId) throws Exception;

    ProductDTO save(ProductDTO productDTO);

    void deleteById(Long theId);
}
