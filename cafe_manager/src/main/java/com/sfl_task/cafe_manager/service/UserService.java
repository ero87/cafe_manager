package com.sfl_task.cafe_manager.service;

import com.sfl_task.cafe_manager.entity.UserEntity;
import com.sfl_task.cafe_manager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void saveUser(UserEntity userEntity) {
        userRepository.save(userEntity);
    }

    public Optional<UserEntity> findUserById(int id) {
        UserEntity entity = userRepository.findById(id).orElse(null);
        return Optional.ofNullable(entity);
    }
}
