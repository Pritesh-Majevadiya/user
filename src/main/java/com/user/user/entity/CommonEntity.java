package com.user.user.entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Getter
@Setter
public class CommonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "_id")
    private Long id;

    @Column(name = "created_by")
    private Long createdBy;

    @Column(name = "updated_by")
    private Long updatedBy;

    @Column(name = "creted_date")
    private Date cretedDate;

    @Column(name = "updated_date")
    private Date updatedDate;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "is_deleted")
    private Boolean isDeleted;
}
