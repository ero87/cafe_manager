package com.sfl_task.cafe_manager.service;

import com.sfl_task.cafe_manager.entity.ProductEntity;
import com.sfl_task.cafe_manager.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public void saveProduct(ProductEntity productEntity) {
        productRepository.save(productEntity);
    }

    public Optional<ProductEntity> findProductByName(String name) {
        ProductEntity entity = productRepository.findByName(name);
        return Optional.ofNullable(entity);
    }
}
