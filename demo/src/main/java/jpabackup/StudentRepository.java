package jpabackup;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Integer> {

    @Query(value = "SELECT id, name FROM student WHERE id = ?1 AND name = ?2", nativeQuery = true)
    Student test1(Integer id, String name);


}

