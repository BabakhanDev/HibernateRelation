package javaTheBest.practicaTask.dao;

import javaTheBest.practicaTask.entity.Lesson;

import java.util.List;

public interface LesonDao {
    // TODO crud
    String saveLessonToCourse(Long courseId, Lesson lesson);
    Lesson getLessonById(Long lessonId);

    String updateLesson(Long lessonId, Lesson newLesson);

    String deleteLesson(Long lessonId);

    List<Lesson> getAllLessons();

    //    Dop methods
    String deleteLessonByCourseId(Long courseId,Long lessonId);
    List<Lesson> sortLessonByPublishedDate();

}
