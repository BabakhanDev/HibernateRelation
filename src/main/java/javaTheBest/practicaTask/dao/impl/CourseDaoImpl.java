package javaTheBest.practicaTask.dao.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;
import javaTheBest.practicaTask.config.DatabaseConnection;
import javaTheBest.practicaTask.dao.CourseDao;
import javaTheBest.practicaTask.entity.Course;

import java.util.ArrayList;
import java.util.List;

public class CourseDaoImpl implements CourseDao {
EntityManagerFactory em = DatabaseConnection.getEntityManager();
    @Override
    public String saveCourse(Course course) {
        EntityManager entityManager = em.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(course);
        entityManager.getTransaction().commit();
        entityManager.close();
        return " Successfully saved the course.";
    }

    @Override
    public int countOfStudentByCourseId(Long courseId) {
        EntityManager entityManager = em.createEntityManager();
        entityManager.getTransaction().begin();
        Long  courseId1  = entityManager.createQuery("select count(s.id) from Student s  inner join s.courses sc"
                + " where sc.id = :courseId ",Long.class ).setParameter("courseId", courseId).getSingleResult();
        entityManager.getTransaction().commit();
        entityManager.close();
        return courseId1.intValue();
    }

    @Override
    public Course getCourseById(Long courseId) {
        EntityManager entityManager = em.createEntityManager();
        entityManager.getTransaction().begin();
        Course courseId1 = entityManager.createQuery("select c from Course c where c.id = :courseId ", Course.class).setParameter("courseId", courseId)
                .getSingleResult();
        entityManager.getTransaction().commit();
        entityManager.close();
        return courseId1;
    }

    @Override
    public String updateCourse(Long courseId, Course newCourse) {
        EntityManager entityManager = em.createEntityManager();
        entityManager.getTransaction().begin();
        Course course = entityManager.find(Course.class, courseId);
        course.setName(newCourse.getName());
        course.setDateOfStart(newCourse.getDateOfStart());
        course.setPrice(newCourse.getPrice());
        entityManager.getTransaction().commit();
        entityManager.close();
        return "Successfully updated the course.";
    }

    @Override
    public String deleteCourse(Long courseId) {
        EntityManager entityManager = em.createEntityManager();
        entityManager.getTransaction().begin();
        Course course = entityManager.find(Course.class, courseId);
        entityManager.remove(course);
        entityManager.getTransaction().commit();
        entityManager.close();
        return "Successfully deleted the course.";
    }

    @Override
    public List<Course> getAllCourse() {
        List<Course> courses = new ArrayList<>();
        EntityManager entityManager = em.createEntityManager();
        entityManager.getTransaction().begin();
        TypedQuery<Course> selectCFromCourseC = entityManager.createQuery("select c from Course c", Course.class);
        courses = selectCFromCourseC.getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return courses;
    }

    @Override
    public void deleteAllStudentByCourseId(Long courseId) {
        EntityManager entityManager = em.createEntityManager();
        entityManager.getTransaction().begin();
        Long  courseId1  = entityManager.createQuery("select count(s.id) from Student s  inner join s.courses sc"
                + " where sc.id = :courseId ",Long.class ).setParameter("courseId", courseId).getSingleResult();
        entityManager.remove(courseId1);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public List<Course> sortCoursesByPriceDesc() {
        EntityManager entityManager = em.createEntityManager();
        entityManager.getTransaction().begin();
        List<Course> sortedCourses;

        try {
            TypedQuery<Course> query = entityManager.createQuery(
                    "SELECT c FROM Course c ORDER BY c.price DESC", Course.class);
            sortedCourses = query.getResultList();
        } finally {
            entityManager.close();
        }

        return sortedCourses;
    }
}
