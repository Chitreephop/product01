package th.ac.utc.Product.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import th.ac.utc.Product.Service.InMemoryStudentService;
import th.ac.utc.Product.Service.StudentService;
import th.ac.utc.Product.model.Student;

import java.util.List;

@RestController
public class StudentController {

    private final StudentService studentService = new InMemoryStudentService();

    @GetMapping("/students")
    public List<Student> list() {
        return studentService.findAll();
    }

    @GetMapping("/student")
    public Student one(@RequestParam Long id) {
        return studentService.findById(id).orElse(null);
    }
}