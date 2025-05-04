package com.homework.springBoot.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "televisions", schema = "public")
public class Television {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="name", nullable = false)
    private String name;
    @Column(name = "model")
    private String model;
    @Column(name = "price")
    private Long price;
    @Column(name = "description")
    private String description;
}


