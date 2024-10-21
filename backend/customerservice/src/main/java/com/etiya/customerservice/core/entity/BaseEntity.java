package com.etiya.customerservice.core.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@MappedSuperclass
@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class BaseEntity {
    @Column(name = "created_date", updatable = false)
    private LocalDateTime createdDate;

    @Column(name = "updated_date")
    private LocalDateTime updatedDate;

    @Column(name = "deleted_date")
    private LocalDateTime deletedDate;

    @PrePersist
    protected void onCreate(){
        createdDate = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate(){
        updatedDate = LocalDateTime.now();
    }
}
