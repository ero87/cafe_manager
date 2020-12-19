package com.sfl_task.cafe_manager.service;

import com.sfl_task.cafe_manager.entity.RoleEntity;
import com.sfl_task.cafe_manager.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public long getRolesCount() {
        return roleRepository.count();
    }

    public void saveRole(RoleEntity roleEntity) {
        roleRepository.save(roleEntity);
    }

    public Optional<RoleEntity> getByRoleId(int id) {
        RoleEntity roleEntity = roleRepository.findById(id).orElse(null);
        return Optional.ofNullable(roleEntity);
    }
}
