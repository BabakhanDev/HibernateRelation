package javaTheBest.practicaTask.dao.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.NoResultException;
import javaTheBest.practicaTask.config.DatabaseConnection;
import javaTheBest.practicaTask.dao.MentorDao;
import javaTheBest.practicaTask.entity.Course;
import javaTheBest.practicaTask.entity.Lesson;
import javaTheBest.practicaTask.entity.Mentor;
import javaTheBest.practicaTask.entity.Student;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MentorDaoImpl implements MentorDao {
    EntityManagerFactory em = DatabaseConnection.getEntityManager();
    @Override
    public Mentor getMentorById(Long mentorId) {
        EntityManager entityManager = em.createEntityManager();
        entityManager.getTransaction().begin();
        Mentor mentor = entityManager.find(Mentor.class, mentorId);
        entityManager.getTransaction().commit();
        entityManager.close();
        return mentor;
    }

    @Override
    public String updateMentor(Long mentorId, Mentor newMentor) {
        EntityManager entityManager = em.createEntityManager();
        entityManager.getTransaction().begin();
        Mentor mentor = entityManager.find(Mentor.class, mentorId);
        mentor.setFirstName(newMentor.getFirstName());
        mentor.setEmail(newMentor.getEmail());
        mentor.setYearOfBirth(newMentor.getYearOfBirth());
        entityManager.getTransaction().commit();
        entityManager.close();
        return "Successfully updated Mentor";
    }

    @Override
    public String deleteMentor(Long mentorId) {
        EntityManager entityManager = em.createEntityManager();
        entityManager.getTransaction().begin();
        Mentor mentor = entityManager.find(Mentor.class, mentorId);
        entityManager.remove(mentor);
        entityManager.getTransaction().commit();
        entityManager.close();
        return "Successfully deleted Mentor";
    }

    @Override
    public List<Mentor> getAllMentors() {
        EntityManager entityManager = em.createEntityManager();
        entityManager.getTransaction().begin();
        List<Mentor> mentors = entityManager.createQuery("select m from Mentor m")
                .getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return mentors;
    }

        @Override
        public Map<Lesson, List<Student>> getAllLessonAndStudentByMentor(String nameMentor) {
            EntityManager entityManager = em.createEntityManager();
            Map<Lesson, List<Student>> lessonAndStudents = new HashMap<>();

            try {

                Mentor mentor = entityManager.createQuery(
                                "SELECT m FROM Mentor m WHERE m.name = :nameMentor", Mentor.class)
                        .setParameter("nameMentor", nameMentor)
                        .getSingleResult();

                if (mentor != null) {
                    List<Lesson> lessons = entityManager.createQuery(
                                    "SELECT l FROM Lesson l WHERE l.mentor = :mentor", Lesson.class)
                            .setParameter("mentor", mentor)
                            .getResultList();

                    // Для каждого урока получаем список студентов
                    for (Lesson lesson : lessons) {
                        List<Student> students = entityManager.createQuery(
                                        "SELECT s FROM Student s JOIN s.lessons l WHERE l = :lesson", Student.class)
                                .setParameter("lesson", lesson)
                                .getResultList();

                        // Добавляем урок и соответствующих студентов в результат
                        lessonAndStudents.put(lesson, students);
                    }
                }
            } catch (NoResultException e) {
                System.out.println("Mentor not found: " + nameMentor);
            } finally {
                entityManager.close();
            }

            return lessonAndStudents;
        }

    }
