package com.b22cn539.expense_management.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@MappedSuperclass
@EntityListeners(value = AuditingEntityListener.class)
@Getter
@Setter
public class BaseEntity {
    @CreatedDate
    @Column(updatable = false)
    private Date createdDate;
    @LastModifiedDate
    @Column(insertable = false)
    private Date modifiedDate;
}
