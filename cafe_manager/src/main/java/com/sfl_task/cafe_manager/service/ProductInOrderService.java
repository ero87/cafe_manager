package com.sfl_task.cafe_manager.service;

import com.sfl_task.cafe_manager.entity.ProductInOrderEntity;
import com.sfl_task.cafe_manager.repository.ProductInOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductInOrderService {

    @Autowired
    private ProductInOrderRepository productInOrderRepository;

    public void saveProductInOrder(ProductInOrderEntity productInOrderEntity) {
        productInOrderRepository.save(productInOrderEntity);
    }

    public Optional<ProductInOrderEntity> getProductInOrderById(int id) {
        return Optional.ofNullable(productInOrderRepository.findByProductInOrderId(id));
    }
}
