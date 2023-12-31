package studentapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class StudentController {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @PostMapping("/students")
    public String insert(@RequestBody Student student) {

        String sql = "INSERT INTO student (name) VALUE (:studentName);";

        Map<String, Object> map = new HashMap<>();
        map.put("studentName", student.getName());

        KeyHolder keyHolder = new GeneratedKeyHolder();

        namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource(map), keyHolder);

        int id = keyHolder.getKey().intValue();

        return "INSERT successfully" + "mysql generated id:" + id;
    }

    @PostMapping("/students/batch")
    public String insertList(@RequestBody List<Student> studentList) {

        String sql = "INSERT INTO student (name) VALUE (:studentName);";

        MapSqlParameterSource[] parameterSources = new MapSqlParameterSource[studentList.size()];

        for (int i = 0; i < studentList.size(); i++) {
            Student student = studentList.get(i);

            parameterSources[i] = new MapSqlParameterSource();
            parameterSources[i].addValue("studentName", student.getName());
        }

        namedParameterJdbcTemplate.batchUpdate(sql, parameterSources);

        return "Batch insert successfully";
    }


    @DeleteMapping("/students/{studentId}")
    public String delete(@PathVariable Integer studentId) {

        String sql = "DELETE FROM student WHERE id = :studentId;";

        Map<String, Object> map = new HashMap<>();
        map.put("studentId", studentId);

        namedParameterJdbcTemplate.update(sql, map);

        return "DELETE successfully";
    }

    @GetMapping("/students")
    public List<Student> select() {

        String sql = "SELECT id, name FROM student;";

        Map<String, Object> map = new HashMap<>();

        List<Student> list = namedParameterJdbcTemplate.query(sql, map, new StudentRowMapper());

        return list;
    }

//    @GetMapping("/students/{studentId}")
//    public Student select_one(@PathVariable int studentId) {
//
//        String sql = "SELECT id, name FROM student WHERE id = :studentId";
//
//        Map<String, Object> map = new HashMap<>();
//        map.put("studentId", studentId);
//
//        List<Student> list = namedParameterJdbcTemplate.query(sql, map, new StudentRowMapper());
//
//        if (list.size() > 0) {
//            return list.get(0);
//        } else {
//            return null;
//        }
//
//    }

    @GetMapping("/students/{studentId}")
    public void count(@PathVariable int studentId) {
        String countSql = "SELECT COUNT(*) FROM student";

        Map<String, Object> map = new HashMap<>();

        Integer count = namedParameterJdbcTemplate.queryForObject(countSql, map, Integer.class);

        System.out.println("Total count in student table: " + count);
    }


}
