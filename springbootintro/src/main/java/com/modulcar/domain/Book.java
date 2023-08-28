package com.modulcar.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Setter;
import jakarta.persistence.Id;
import lombok.NoArgsConstructor;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Setter
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("bookName")
    private String name;
}
