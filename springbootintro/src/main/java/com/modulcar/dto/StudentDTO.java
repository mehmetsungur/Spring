package com.modulcar.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Getter
@Service
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {
    private Long id; // int id : default 0

    @NotNull(message = "first name can not be null")
    @NotBlank(message = "first name can not be white space")
    @Size(min=2,max = 25,message = "First name '${validatedValue}' must be between {min} and {max} long")
    private String name; //

    private String lastName;

    private Integer grade;

    @Email(message = "Provide valid email")
    private String email; // aba@

    private String phoneNumber;

    private LocalDateTime createDate = LocalDateTime.now();
}
