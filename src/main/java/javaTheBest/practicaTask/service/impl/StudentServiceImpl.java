package javaTheBest.practicaTask.service.impl;

import javaTheBest.practicaTask.dao.StudentDao;
import javaTheBest.practicaTask.dao.impl.StudentDaoImpl;
import javaTheBest.practicaTask.entity.Lesson;
import javaTheBest.practicaTask.entity.Student;
import javaTheBest.practicaTask.service.StudentService;

import java.util.List;
import java.util.Map;

public class StudentServiceImpl implements StudentService {

    private final StudentDao studentDao = new StudentDaoImpl();

    @Override
    public String saveStudent(Student student) {
        return studentDao.saveStudent(student);
    }

    @Override
    public String assignStudentByCourseId(Long studentId, Long courseId) {
        return studentDao.assignStudentByCourseId(studentId, courseId);
    }

    @Override
    public Student getStudentById(Long studentId) {
        return studentDao.getStudentById(studentId);
    }

    @Override
    public String updateStudent(Long studentId, Student newStudent) {
        studentDao.updateStudent(studentId, newStudent);
        return "Student updated";
    }

    @Override
    public String deleteStudent(Long studentId) {
        studentDao.deleteStudent(studentId);
        return "Student deleted ";
    }

    @Override
    public List<Student> getAllStudents() {
        return studentDao.getAllStudents();
    }

    @Override
    public Map<Student, List<Lesson>> getAllLessonByStudent() {
        return studentDao.getAllLessonByStudent();
    }
}