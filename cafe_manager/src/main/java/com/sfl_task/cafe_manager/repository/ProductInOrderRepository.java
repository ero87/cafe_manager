package com.sfl_task.cafe_manager.repository;

import com.sfl_task.cafe_manager.entity.ProductInOrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductInOrderRepository extends JpaRepository<ProductInOrderEntity, Integer> {
    ProductInOrderEntity save(ProductInOrderEntity productInOrderEntity);
    ProductInOrderEntity findByProductInOrderId(int id);
}
