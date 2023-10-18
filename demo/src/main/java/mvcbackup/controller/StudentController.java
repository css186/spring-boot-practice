package mvcbackup.controller;

import mvcbackup.model.Student;
import mvcbackup.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/students/{studentId}")
    public Student select(@PathVariable Integer studentId) {

        return studentService.getById(studentId);

    }

    @PostMapping("/students")
    public String create(@RequestBody Student student) {

        return studentService.insert(student);
    }

    @GetMapping("/students")
    public List<Student> getAll() {
        return studentService.getAll();
    }

    @DeleteMapping("/students/{studentId}")
    public String delete(@PathVariable Integer studentId) {
        return studentService.delete(studentId);
    }

}
