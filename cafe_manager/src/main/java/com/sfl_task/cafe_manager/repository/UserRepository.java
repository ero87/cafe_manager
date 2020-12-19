package com.sfl_task.cafe_manager.repository;

import com.sfl_task.cafe_manager.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    UserEntity save(UserEntity userEntity);
}
