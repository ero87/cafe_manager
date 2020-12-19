package com.sfl_task.cafe_manager.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "tableOrder")
public class TableOrderEntity implements Serializable {
    public TableOrderEntity() {
    }

    public TableOrderEntity(StatusEntity statusEntity, TableEntity tableEntity) {
        this.statusId = statusEntity;
        this.tableId = tableEntity;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;

    @ManyToOne
    @JoinColumn(name = "tableId")
    private TableEntity tableId;

    @ManyToOne
    @JoinColumn(name = "statusId")
    private StatusEntity statusId;
}
