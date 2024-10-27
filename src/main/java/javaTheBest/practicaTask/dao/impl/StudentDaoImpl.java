package javaTheBest.practicaTask.dao.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import javaTheBest.practicaTask.config.DatabaseConnection;
import javaTheBest.practicaTask.dao.StudentDao;
import javaTheBest.practicaTask.entity.Lesson;
import javaTheBest.practicaTask.entity.Student;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentDaoImpl implements StudentDao {
    EntityManagerFactory entityManagerFactory = DatabaseConnection.getEntityManager();
    @Override
    public String saveStudent(Student student) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(student);
//        entityManager.merge(student);
        entityManager.getTransaction().commit();
        entityManager.close();
        return "success" ;
    }

    @Override
    public String assignStudentByCourseId(Long studentId, Long courseId) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Student student = entityManager.find(Student.class, studentId);
        List courseId1 = entityManager.createQuery("select c from Course c where c.id = :courseId")
                .setParameter("courseId", courseId).getResultList();
        student.setCourses(courseId1);
        entityManager.getTransaction().commit();
        entityManager.close();
        return "Success ";
    }

    @Override
    public Student getStudentById(Long studentId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Student student = entityManager.find(Student.class, studentId);
        entityManager.getTransaction().commit();
        entityManager.close();
        return student;
    }

    @Override
    public String updateStudent(Long studentId, Student newStudent) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Student student = entityManager.find(Student.class, studentId);
        student.setFirstName(newStudent.getFirstName());
        student.setYearOfBirth(newStudent.getYearOfBirth());
        student.setEmail(newStudent.getEmail());
        entityManager.getTransaction().commit();
        entityManager.close();
        return "Successfully updated student";
    }

    @Override
    public String deleteStudent(Long studentId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Student student = entityManager.find(Student.class, studentId);
        entityManager.remove(student);
        entityManager.getTransaction().commit();
        entityManager.close();
        return "Successfully deleted student";
    }

    @Override
    public List<Student> getAllStudents() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        List<Student> students = entityManager.createQuery("from Student")
                .getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return students;
    }

        @Override
        public Map<Student, List<Lesson>> getAllLessonByStudent() {
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            Map<Student, List<Lesson>> studentLessons = new HashMap<>();

            try {
                List<Student> students = entityManager.createQuery("SELECT s FROM Student s", Student.class).getResultList();

                for (Student student : students) {
                    List<Lesson> lessons = entityManager.createQuery(
                                    "SELECT l FROM Lesson l JOIN l.students s WHERE s = :student", Lesson.class)
                            .setParameter("student", student)
                            .getResultList();

                    studentLessons.put(student, lessons);
                }
            } finally {
                entityManager.close();
            }

            return studentLessons;
        }

    }

