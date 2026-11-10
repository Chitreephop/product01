package th.ac.utc.Product.Service;

import org.springframework.stereotype.Service;
import th.ac.utc.Product.model.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class InMemoryStudentService implements StudentService {

    private final List<Student> students = new ArrayList<>();
    private long nextId = 1;

    public InMemoryStudentService() {
        save(new Student(null, "John", 3.5));
        save(new Student(null, "kewin", 3.8));
    }

    @Override
    public List<Student> findAll() {
        return students;
    }

    @Override
    public Optional<Student> findById(Long id) {
        return students.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
    }
    @Override
    public Student save(Student student) {
        student.setId(nextId++);
        students.add(student);
        return student;
    }
}
