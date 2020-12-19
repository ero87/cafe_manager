package com.sfl_task.cafe_manager.repository;

import com.sfl_task.cafe_manager.entity.StatusEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusRepository extends JpaRepository<StatusEntity, Integer> {
    StatusEntity save(StatusEntity statusEntity);
    StatusEntity getStatusEntityByName(String name);
    StatusEntity getStatusEntityByStatusId(int id);
}
