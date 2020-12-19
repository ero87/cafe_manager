package com.sfl_task.cafe_manager.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "status")
@AllArgsConstructor
@NoArgsConstructor
public class StatusEntity implements Serializable {

    public StatusEntity(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int statusId;

    @NotNull
    private String name;
}
