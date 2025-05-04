package com.cinema.cinema.model;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@NoArgsConstructor
@MappedSuperclass

public class GenericModel {
    @Column(name = "created when")
    private LocalDate createdWhen;
    @Column(name = "created by")
    private String createdBy;
}
