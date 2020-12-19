package com.sfl_task.cafe_manager.service;

import com.sfl_task.cafe_manager.entity.TableEntity;
import com.sfl_task.cafe_manager.entity.UserEntity;
import com.sfl_task.cafe_manager.repository.TableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TableService {

    @Autowired
    private TableRepository tableRepository;

    public void saveTable(TableEntity tableEntity) {
        tableRepository.save(tableEntity);
    }

    public Optional<List<TableEntity>> findUserByWaiterId(UserEntity userEntity) {
        List<TableEntity> entityList = tableRepository.findAllByUserId(userEntity);
        return Optional.ofNullable(entityList);
    }

    public Optional<TableEntity> findTableById(int id) {
        TableEntity entityList = tableRepository.findByTableId(id);
        return Optional.ofNullable(entityList);
    }

}
