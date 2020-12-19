package com.sfl_task.cafe_manager.repository;

import com.sfl_task.cafe_manager.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {
    ProductEntity save(ProductEntity productEntity);
    ProductEntity findByName(String name);
}
