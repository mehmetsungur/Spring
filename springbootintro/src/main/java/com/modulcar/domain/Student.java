package com.modulcar.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;
import org.jetbrains.annotations.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(force = true)
//@RequiredArgsConstructor

@Entity
public class Student {
    /*    @Getter*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id; // int id : default 0
    @NotNull(message = "first name can not be null")
    @NotBlank(message = "first name can not be white space")
    @Size(min=2,max = 25,message = "First name '${validatedValue}' must be between {min} and {max} long")
/*    @Getter
    @Setter*/
    @Column(nullable = false, length = 25)
    private /*final*/ String name; //

    @Column(nullable = false, length = 25)
    private /*final*/ String lastName;

    private /*final */Integer grade;

    @Column(nullable = false, length = 25, unique = true)
    @Email(message = "Provide valid email")
    private /*final*/  String email; // aba@

    private/* final*/ String phoneNumber;

    @Setter(AccessLevel.NONE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy HH:mm:ss", timezone = "Turkey")
    private LocalDateTime createDate = LocalDateTime.now();
}