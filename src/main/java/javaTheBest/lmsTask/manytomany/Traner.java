package javaTheBest.lmsTask.manytomany;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@Getter
@Setter
@ToString
@Table(name = "traners")
public class Traner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String courseName;

    @ManyToMany(mappedBy = "traners")
    private List<Sportsmen> sportsmens;

}
