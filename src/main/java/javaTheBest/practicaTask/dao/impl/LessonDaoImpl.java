package javaTheBest.practicaTask.dao.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;
import javaTheBest.practicaTask.config.DatabaseConnection;
import javaTheBest.practicaTask.dao.LesonDao;
import javaTheBest.practicaTask.entity.Course;
import javaTheBest.practicaTask.entity.Lesson;

import java.util.ArrayList;
import java.util.List;

public class LessonDaoImpl implements LesonDao {
    EntityManagerFactory em = DatabaseConnection.getEntityManager();
    @Override
    public String saveLessonToCourse(Long courseId, Lesson lesson) {
        EntityManager entityManager = em.createEntityManager();
        entityManager.getTransaction().begin();
        Course course = entityManager.find(Course.class, courseId);
        lesson.setCourses(course);
        entityManager.persist(lesson);
        entityManager.getTransaction().commit();
        entityManager.close();
        return "Saved";
    }

    @Override
    public Lesson getLessonById(Long lessonId) {
        EntityManager entityManager = em.createEntityManager();
        entityManager.getTransaction().begin();
        Lesson lesson = entityManager.find(Lesson.class, lessonId);
        entityManager.getTransaction().commit();
        entityManager.close();
        return lesson;
    }

    @Override
    public String updateLesson(Long lessonId, Lesson newLesson) {
        EntityManager entityManager = em.createEntityManager();
        entityManager.getTransaction().begin();
        Lesson lesson = entityManager.find(Lesson.class, lessonId);
        lesson.setDescription(newLesson.getDescription());
        lesson.setTitle(newLesson.getTitle());
        lesson.setPublishedDate(newLesson.getPublishedDate());
        lesson.setVideoLink(newLesson.getVideoLink());
        entityManager.getTransaction().commit();
        entityManager.close();
        return "Successfully updated";
    }

    @Override
    public String deleteLesson(Long lessonId) {
        EntityManager entityManager = em.createEntityManager();
        entityManager.getTransaction().begin();
        Lesson lesson = entityManager.find(Lesson.class, lessonId);
        if (lesson != null) {
            entityManager.remove(lesson);
            entityManager.getTransaction().commit();
            return "Successfully deleted";
        } else {
            entityManager.getTransaction().rollback();
            return "Lesson not found";
        }
    }

    @Override
    public List<Lesson> getAllLessons() {
        List<Lesson> lessons = new ArrayList<Lesson>();
        EntityManager entityManager = em.createEntityManager();
        entityManager.getTransaction().begin();
        TypedQuery<Lesson> selectLFromLessonL = entityManager.createQuery("select l from Lesson l", Lesson.class);
        lessons = selectLFromLessonL.getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return lessons;
    }

    @Override
    public String deleteLessonByCourseId(Long courseId, Long lessonId) {
        EntityManager entityManager = em.createEntityManager();
        entityManager.getTransaction().begin();

        try {
            Lesson lesson = entityManager.createQuery(
                            "SELECT l FROM Lesson l JOIN l.courses c " +
                                    "WHERE c.id = :courseId AND l.id = :lessonId", Lesson.class)
                    .setParameter("courseId", courseId)
                    .setParameter("lessonId", lessonId)
                    .getSingleResult();
            entityManager.remove(lesson);
            entityManager.getTransaction().commit();
            return "Successfully deleted";
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
            return "Failed to delete the lesson";
        } finally {
            entityManager.close();
        }
    }
    @Override
    public List<Lesson> sortLessonByPublishedDate() {
        EntityManager entityManager = em.createEntityManager();
     List<Lesson> sortedLesson;
     try {
         TypedQuery<Lesson> query = entityManager.createQuery("SELECT l FROM Lesson l ORDER BY l.publishedDate asc", Lesson.class);
         sortedLesson = query.getResultList();
     }finally {
         entityManager.close();
     }
     return sortedLesson;
    }
}
