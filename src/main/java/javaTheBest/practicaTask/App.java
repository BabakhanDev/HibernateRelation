package javaTheBest.practicaTask;

import javaTheBest.practicaTask.config.DatabaseConnection;
import javaTheBest.practicaTask.entity.Course;
import javaTheBest.practicaTask.entity.Student;
import javaTheBest.practicaTask.service.CourseService;
import javaTheBest.practicaTask.service.StudentService;
import javaTheBest.practicaTask.service.impl.CourseServiceImpl;
import javaTheBest.practicaTask.service.impl.StudentServiceImpl;

import java.time.LocalDate;
public class App {
    public static void main(String[] args) {
        DatabaseConnection db = new DatabaseConnection();
        DatabaseConnection.getEntityManager();
        StudentService studentService = new StudentServiceImpl();
        CourseService courseService = new CourseServiceImpl();
//        courseService.saveCourse(new Course("Js12", LocalDate.of(2024,6,26),12000));
//        studentService.saveStudent(new Student("Atai","atai@gmail.com",2005));
//        studentService.saveStudent(new Student("Askat ","ackat@gmail.com",1988));
//        studentService.saveStudent(new Student("Babakhan","babakhan@gmail.com",1993));
//        studentService.saveStudent(new Student("Baisalbek","baisalbek@gmail.com",2006));
//        studentService.saveStudent(new Student("Nuradil","nuradil@gmail.com",1997));
//
//        System.out.println(studentService.assignStudentByCourseId(2L, 1L));
//        System.out.println(studentService.assignStudentByCourseId(3L, 2L));
//
//        System.out.println(courseService.countOfStudentByCourseId(1L));
//        System.out.println(courseService.getCourseById(1L));

    }
}