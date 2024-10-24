package javaTheBest.practicaTask.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "lessons")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "lesson_gen")
    @SequenceGenerator(name = "lesson_gen", sequenceName = "lesson_seq", allocationSize = 1)
    private Long id;
    private String title;
    private String description;
    private LocalDate publishedDate;
    private String videoLink;
    private boolean isPresentation;

    @ManyToOne
    private Course courses;
    @OneToOne
    private Task task;

}

