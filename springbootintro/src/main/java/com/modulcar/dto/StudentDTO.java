package com.modulcar.dto;

import lombok.*;
import java.time.LocalDateTime;
import com.modulcar.domain.Student;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Email;
import org.springframework.stereotype.Service;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotBlank;

@Getter
@Service
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {
    private Long id; // int id : default 0

    @NotNull(message = "first name can not be null")
    @NotBlank(message = "first name can not be white space")
    @Size(min=2,max = 25,message = "First name '${validatedValue}' must be between {min} and {max} long")
    private String firstName;

    private String lastName;

    private Integer grade;

    @Email(message = "Provide valid email")
    private String email;

    private String phoneNumber;

    private LocalDateTime createDate = LocalDateTime.now();

    public StudentDTO(Student student){
        this.id = student.getId();
        this.grade = student.getGrade();
        this.email = student.getEmail();
        this.firstName = student.getName();
        this.lastName = student.getLastName();
        this.createDate = student.getCreateDate();
        this.phoneNumber = student.getPhoneNumber();
    }
}
