package javaTheBest.practicaTask.service.impl;

import jakarta.persistence.EntityManager;
import javaTheBest.practicaTask.config.DatabaseConnection;
import javaTheBest.practicaTask.dao.CourseDao;
import javaTheBest.practicaTask.dao.LesonDao;
import javaTheBest.practicaTask.dao.impl.CourseDaoImpl;
import javaTheBest.practicaTask.dao.impl.LessonDaoImpl;
import javaTheBest.practicaTask.entity.Course;
import javaTheBest.practicaTask.entity.Lesson;
import javaTheBest.practicaTask.service.LessonService;

import java.util.List;

public class LessonServiceImpl implements LessonService {
    private final LesonDao lessonDao = new LessonDaoImpl();
    @Override
    public Lesson getLessonById(Long lessonId) {
        return lessonDao.getLessonById(lessonId);
    }

    @Override
    public String updateLesson(Long lessonId, Lesson newLesson) {
        lessonDao.updateLesson(lessonId, newLesson);
        return "Successfully updated Lesson";
    }

    @Override
    public String deleteLesson(Long lessonId) {
lessonDao.deleteLesson(lessonId);
        return "Successfully deleted Lesson";
    }

    @Override
    public List<Lesson> getAllLessons() {
        return   lessonDao.getAllLessons();

    }

    @Override
    public String deleteLessonByCourseId(Long courseId, Long lessonId) {
        lessonDao.deleteLessonByCourseId(courseId, lessonId);
        return "Successfully deleted Lesson";
    }

    @Override
    public List<Lesson> sortLessonByPublishedDate() {
        return lessonDao.sortLessonByPublishedDate();
    }
}
