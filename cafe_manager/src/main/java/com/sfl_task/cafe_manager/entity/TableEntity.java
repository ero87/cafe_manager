package com.sfl_task.cafe_manager.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "table_")
@NoArgsConstructor
@AllArgsConstructor
public class TableEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tableId;

    @ManyToOne
    @JoinColumn(name = "userId")
    private UserEntity userId;

    @ManyToOne
    @JoinColumn(name = "statusId")
    private StatusEntity statusId;
}
