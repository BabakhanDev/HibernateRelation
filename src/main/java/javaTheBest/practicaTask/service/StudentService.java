package javaTheBest.practicaTask.service;

import javaTheBest.practicaTask.entity.Course;
import javaTheBest.practicaTask.entity.Lesson;
import javaTheBest.practicaTask.entity.Student;

import java.util.List;
import java.util.Map;

public interface StudentService {
    String saveStudent(Student student);

    String assignStudentByCourseId(Long studentId, Long Id);


   Student getStudentById(Long studentId);

    String updateStudent(Long studentId, Student newStudent);

    String deleteStudent(Long studentId);

    List<Student> getAllStudents();
    Map<Student, List<Lesson>> getAllLessonByStudent();

}
