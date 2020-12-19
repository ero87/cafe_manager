package com.sfl_task.cafe_manager.repository;

import com.sfl_task.cafe_manager.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Integer> {
    RoleEntity save(RoleEntity roleEntity);
}
