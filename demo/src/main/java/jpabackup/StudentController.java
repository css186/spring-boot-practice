package jpabackup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;


    // Create
    @PostMapping("/students")
    public String insert(@RequestBody Student student) {

        studentRepository.save(student);

        return "INSERT data Executed.";
    }

    // Read
    @GetMapping("/students/{studentId}")
    public Student read(@PathVariable Integer studentId) {

        Student student = studentRepository.findById(studentId).orElse(null);

        return student;
    }

    // Update
    @PutMapping("/students/{studentId}")
    public String update(@PathVariable Integer studentId,
                         @RequestBody Student student) {

        Student s = studentRepository.findById(studentId).orElse(null);

        if (s != null) {
            s.setName(student.getName());
            studentRepository.save(s);

            return "UPDATE data Executed.";
        } else {
            return "UPDATE Failed, data does not exist.";
        }

    }


    // Delete
    @DeleteMapping("/students/{studentId}")
    public String delete(@PathVariable Integer studentId) {

        studentRepository.deleteById(studentId);

        return "DELETE data Executed.";
    }

}
