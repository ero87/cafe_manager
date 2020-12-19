package com.sfl_task.cafe_manager.service;

import com.sfl_task.cafe_manager.entity.TableEntity;
import com.sfl_task.cafe_manager.entity.TableOrderEntity;
import com.sfl_task.cafe_manager.repository.TableOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TableOrderService {

    @Autowired
    private TableOrderRepository tableOrderRepository;

    public void saveOrder(TableOrderEntity tableOrderEntity) {
        tableOrderRepository.save(tableOrderEntity);
    }

    public Optional<TableOrderEntity> findByTableId(TableEntity tableEntity) {
        return Optional.ofNullable(tableOrderRepository.findByTableId(tableEntity));
    }

    public Optional<TableOrderEntity> findByOrderId(int orderId) {
        return Optional.ofNullable(tableOrderRepository.findByOrderId(orderId));
    }

}
