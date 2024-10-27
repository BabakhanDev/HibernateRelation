package javaTheBest.practicaTask.dao;

import javaTheBest.practicaTask.entity.Lesson;
import javaTheBest.practicaTask.entity.Student;

import java.util.List;
import java.util.Map;

public interface StudentDao {
    String saveStudent(Student student);

    String assignStudentByCourseId(Long studentId, Long courseId);

    // TODO crud method
    Student getStudentById(Long studentId);

    String updateStudent(Long studentId, Student newStudent);

    String deleteStudent(Long studentId);

    List<Student> getAllStudents();


    Map<Student, List<Lesson>> getAllLessonByStudent();
}
