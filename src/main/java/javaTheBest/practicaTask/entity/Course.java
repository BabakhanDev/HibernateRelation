package javaTheBest.practicaTask.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "courses")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "course_gen")
    @SequenceGenerator(name = "course_gen",sequenceName = "course_gen",allocationSize=1)
        private Long id;
    private String name;
    private int price;
    private LocalDate dateOfStart;

    @ManyToMany
    private List<Mentor> mentors;

    @ManyToMany(mappedBy = "courses")
    private List<Student> students;

    @OneToMany(mappedBy = "courses")
    private List<Lesson> lessons;

    public Course(String name, LocalDate dateOfStart, int price) {
        this.name = name;
        this.dateOfStart = dateOfStart;
        this.price = price;
    }
}
