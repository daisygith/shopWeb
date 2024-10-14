package sdu.shopWeb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sdu.shopWeb.dto.ProductDTO;
import sdu.shopWeb.entity.Product;
import sdu.shopWeb.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;


@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<ProductDTO> findAllProducts() {
        List<Product> productList = productRepository.findAll();

        List<ProductDTO> productListDTO = new ArrayList<>();

        productList.forEach((Product item) -> {
            productListDTO.add(ProductDTO.builder()
                            .id(item.getId())
                            .name(item.getName())
                            .price(item.getPrice())
                    .build());
        });

        return productListDTO;
    }

    @Override
    public ProductDTO findById(Long productId) throws Exception {

        Product product = productRepository.findById(productId).orElseThrow();

        ProductDTO productDTO = ProductDTO.builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .build();

        return productDTO;
    }

    @Transactional
    @Override
    public ProductDTO save(ProductDTO productDTO) {

        Product product = productRepository.save(Product.builder()
                        .id(productDTO.getId())
                        .name(productDTO.getName())
                        .price(productDTO.getPrice())
                .build());

        ProductDTO productListDTO = ProductDTO.builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .build();

        return productListDTO;
    }

    @Transactional
    @Override
    public void deleteById(Long productId) {
        productRepository.deleteById(productId);
    }
}
