package students;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;

@Validated
@RestController
public class StudentController {

    @PostMapping("/students")
    public String create(@RequestBody @Valid Student student) {
        return "Execute Create in DB";
    }

    @GetMapping("/students/{studentId}")
    public String read(@PathVariable Integer studentId) {
        return "Execute Read in DB";
    }

    @PutMapping("/students/{studentId}")
    public String update(@PathVariable @Min(100) Integer studentId,
                         @RequestBody Student student) {
        return "Execute Update in DB";
    }


    @DeleteMapping("/students/{studentId}")
    public String delete(@PathVariable Integer studentId) {
        return "Execute Delete in DB";
    }

}
