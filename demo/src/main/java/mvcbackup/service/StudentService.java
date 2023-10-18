package mvcbackup.service;

import mvcbackup.model.Student;

import java.util.List;

public interface StudentService {
    Student getById(Integer studentId);

    String insert(Student student);

    String delete(Integer studentId);

    List<Student> getAll();
}
