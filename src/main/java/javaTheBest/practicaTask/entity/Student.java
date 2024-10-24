package javaTheBest.practicaTask.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "students")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_gen")
    @SequenceGenerator(name = "student_gen", sequenceName = "student_seq", allocationSize = 1)
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(unique = true)
    private String email;
    @Column(name = "year_of_birth")
    private int yearOfBirth;
    //
    @ManyToMany
    private List<Course> courses;


    public Student(String firstName, String email, int yearOfBirth) {
        this.firstName = firstName;
        this.email = email;
        this.yearOfBirth = yearOfBirth;
    }
}
