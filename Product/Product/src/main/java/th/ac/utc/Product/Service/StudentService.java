package th.ac.utc.Product.Service;

import java.util.List;
import java.util.Optional;
import th.ac.utc.Product.model.Student;

public interface StudentService {

    List<Student> findAll();

    Optional<Student> findById(Long id);

    Student save(Student student);

}