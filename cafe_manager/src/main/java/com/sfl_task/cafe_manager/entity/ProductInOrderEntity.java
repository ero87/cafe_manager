package com.sfl_task.cafe_manager.entity;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "productInOrder")
public class ProductInOrderEntity implements Serializable {
    public ProductInOrderEntity() {
    }

    public ProductInOrderEntity(ProductEntity productEntity, StatusEntity statusEntity, int count) {
        this.productId = productEntity;
        this.statusId = statusEntity;
        this.count = count;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productInOrderId;

    @ManyToOne
    @JoinColumn(name = "productId")
    private ProductEntity productId;

    @ManyToOne
    @JoinColumn(name = "statusId")
    private StatusEntity statusId;

    @NotNull
    private int count;
}
