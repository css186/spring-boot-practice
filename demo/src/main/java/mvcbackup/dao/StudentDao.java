package mvcbackup.dao;

import mvcbackup.model.Student;

import java.util.List;

public interface StudentDao {

    // Read
    Student getById(Integer studentId);

    // Create
    String insert(Student student);

    // Delete
    String delete(Integer studentId);

    List<Student> getAll();

}
