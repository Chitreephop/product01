package th.ac.utc.Product.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Student {
    private Long id;
    private String name;
    private double grade;
}