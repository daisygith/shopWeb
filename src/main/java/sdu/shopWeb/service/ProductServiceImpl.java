package sdu.shopWeb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sdu.shopWeb.dto.ProductDTO;
import sdu.shopWeb.repository.ProductRepository;

import java.util.List;


@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<ProductDTO> findAllProducts() {
        return null;
    }

    @Override
    public ProductDTO findById(Long theId) throws Exception {
        return null;
    }

    @Override
    public ProductDTO save(ProductDTO productDTO) {
        return null;
    }

    @Override
    public void deleteById(Long theId) {

    }
}
