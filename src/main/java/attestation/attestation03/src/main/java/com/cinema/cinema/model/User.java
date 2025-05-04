package com.cinema.cinema.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User extends GenericModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="user_name", nullable = false)
    private String name;
    @Column (name = "password", nullable = false)
    private String password;
    @Column(name = "description")
    private String description;

    private boolean deleted;

    @OneToMany(mappedBy = "user")
    private List<Review> reviews;


    }