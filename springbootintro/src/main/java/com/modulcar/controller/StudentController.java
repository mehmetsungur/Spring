package com.modulcar.controller;

import java.util.Map;
import java.util.List;
import java.util.HashMap;

import org.slf4j.LoggerFactory;
import jakarta.validation.Valid;
import java.util.logging.Logger;
import com.modulcar.domain.Student;
import com.modulcar.dto.StudentDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import com.modulcar.service.StudentService;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Page;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.PageRequest;

@RestController
@RequiredArgsConstructor
@RequestMapping("/students") //localhost:8080/students
public class StudentController {
    Logger logger = (Logger) LoggerFactory.getLogger(StudentController.class);

    private final StudentService studentService;

    // getAll()
    @GetMapping
    public ResponseEntity<List<Student>> getAll(){
        List<Student> students = studentService.getAll();
        return ResponseEntity.ok(students); //200 + students
    }

    // createStudent()
    @PostMapping
    public ResponseEntity<Map<String,String>> createStudent(@RequestBody @Valid Student student){
        studentService.createStudent(student);

        Map<String,String> map = new HashMap<>();
        map.put("message","Student is created successfully");
        map.put("status","true");

        return new ResponseEntity<>(map, HttpStatus.CREATED); // map + 201
    }

    // getById()
    @GetMapping("/query") //localhost:8080/students/query?id=1
    public ResponseEntity<Student> getStudent(@RequestParam("id") Long id){
        Student student = studentService.findStudent(id);
        return ResponseEntity.ok(student);
    }

    // getStudentWithPath()
    @GetMapping("/{id}") //localhost:8080/students/1
    public ResponseEntity<Student> getStudentWithPath(@PathVariable("id") Long id){
        Student student = studentService.findStudent(id);
        return ResponseEntity.ok(student);
    }

    // deleteStudent()
    @DeleteMapping("/{id}") //localhost:8080/students/1
    public ResponseEntity<String> deleteStudent(@PathVariable("id") Long id){
        studentService.deleteStudent(id);
        String message = "Student is deleted successfully";
        return new ResponseEntity<>(message,HttpStatus.OK);
    }

    // updateStudent()
    @PutMapping("/{id}") //localhost:8080/students/1 + PUT + JSON
    public ResponseEntity<String> updateStudent(@PathVariable Long id, @RequestBody StudentDTO studentDTO){
        studentService.updateStudent(id, studentDTO);
        String message = "Student is deleted successfully";
        return new ResponseEntity<>(message,HttpStatus.OK);
    }

    @GetMapping("/page") //localhost:8080/students/page?page=0&size=10&sort=name&direction=ASC + GET
    public ResponseEntity<Page<Student>> getAllWithPage(@RequestParam("page") int page, @RequestParam("size") int size, @RequestParam("sort") String prop, @RequestParam("direction") Sort.Direction direction){
        Pageable pageable = PageRequest.of(page, size, Sort.by(direction, prop));
        Page<Student> studentPage = studentService.getAllWithPage(pageable);

        return ResponseEntity.ok(studentPage);
    }

    @GetMapping("/grade/{grade}") //localhost:8080/students/grade/75
    public ResponseEntity<List<Student>> getStudentsEqualsGrade(@PathVariable("grade") Integer grade){
        List<Student> students = studentService.findAllEqualsGrade(grade);
        return ResponseEntity.ok(students);
    }

    // DB' den direk DTO olarak verileri almak
    @GetMapping("/query/dto") //localhost:8080/students/query/dto?id=1
    public ResponseEntity<StudentDTO> getStudentDTO(@RequestParam("id") Long id){
        StudentDTO studentDTO = studentService.findStudentDtoById(id);
        return ResponseEntity.ok(studentDTO);
    }

    @GetMapping("/welcome") //localhost:8080/students/welcome + GET
    public String welcome(HttpServletRequest request){
        logger.warning("Welcome {}");
        return "Welcome to Student Controller";
    }
}
