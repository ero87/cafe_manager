package com.sfl_task.cafe_manager.repository;

import com.sfl_task.cafe_manager.entity.TableEntity;
import com.sfl_task.cafe_manager.entity.TableOrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TableOrderRepository extends JpaRepository<TableOrderEntity, Integer> {
    TableOrderEntity save(TableOrderEntity userEntity);
    TableOrderEntity findByTableId(TableEntity tableEntity);
    TableOrderEntity findByOrderId(int id);
}
