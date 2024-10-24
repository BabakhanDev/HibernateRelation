package javaTheBest.practicaTask.entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "mentors")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Mentor {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mentor_gen")
    @SequenceGenerator(name = "mentor_gen", sequenceName = "mentor_seq", allocationSize = 1)
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(unique = true)
    private String email;
    @Column(name = "year_of_birth")
    private int yearOfBirth;
}