package com.sfl_task.cafe_manager.service;

import com.sfl_task.cafe_manager.entity.StatusEntity;
import com.sfl_task.cafe_manager.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StatusService {

    @Autowired
    private StatusRepository statusRepository;

    public long getStatusCount() {
        return statusRepository.count();
    }

    public void saveStatus(StatusEntity statusEntity) {
        statusRepository.save(statusEntity);
    }

    public Optional<StatusEntity> getStatusByName(String status) {
        return Optional.ofNullable(statusRepository.getStatusEntityByName(status));
    }

    public Optional<StatusEntity> getStatusById(int id) {
        StatusEntity entity = statusRepository.getStatusEntityByStatusId(id);
        return Optional.ofNullable(entity);
    }
}
