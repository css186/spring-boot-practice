package mvcbackup.service;

import mvcbackup.model.Student;
import mvcbackup.dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;

    @Override
    public Student getById(Integer studentId) {
        return studentDao.getById(studentId);
    }

    @Override
    public String insert(Student student) {
        return studentDao.insert(student);
    }

    @Override
    public String delete(Integer studentId) {
        return studentDao.delete(studentId);
    }

    @Override
    public List<Student> getAll() {
        return studentDao.getAll();
    }
}
