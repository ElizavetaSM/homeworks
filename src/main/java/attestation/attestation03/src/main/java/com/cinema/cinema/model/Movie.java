package com.cinema.cinema.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "movies")
public class Movie extends GenericModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column (name = "title", nullable = false)
    private String title;
    @Enumerated(value = EnumType.STRING)
    @Column(name = "genre", nullable = false)
    private Genre genre;
    @Column(name = "description")
    private String description;

    private boolean deleted;

    @OneToMany(mappedBy = "movie")
    private List<Review> reviews;

}
