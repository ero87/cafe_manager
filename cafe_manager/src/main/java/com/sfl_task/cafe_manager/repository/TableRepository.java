package com.sfl_task.cafe_manager.repository;

import com.sfl_task.cafe_manager.entity.TableEntity;
import com.sfl_task.cafe_manager.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.List;

@Repository
@EnableTransactionManagement
public interface TableRepository extends JpaRepository<TableEntity, Integer> {
    TableEntity save(TableEntity tableEntity);
    List<TableEntity> findAllByUserId(UserEntity userEntity);
    TableEntity findByTableId(int id);
}
